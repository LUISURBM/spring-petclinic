package org.profamilia.hc.model.service.imp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.profamilia.hc.model.dao.UsuarioDao;
import org.profamilia.hc.model.dto.UsuarioDto;
import org.profamilia.hc.view.backing.LoginBacking;
import org.profamilia.hc.view.util.FacesUtils;

import org.acegisecurity.userdetails.User;
import org.acegisecurity.BadCredentialsException;
import org.acegisecurity.GrantedAuthority;
import org.acegisecurity.GrantedAuthorityImpl;
import org.acegisecurity.userdetails.UserDetails;
import org.acegisecurity.userdetails.UserDetailsService;
import org.acegisecurity.userdetails.UsernameNotFoundException;

import org.springframework.dao.DataAccessException;

public class UsuarioServiceImp implements UserDetailsService {

	private UsuarioDao usuarioDao;
	private LoginBacking loginBacking;

	public UsuarioServiceImp(UsuarioDao usuarioDao) {
		this.usuarioDao = usuarioDao;

	}

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
		this.loginBacking = (LoginBacking) FacesUtils.getManagedBean("loginBacking");
		UsuarioDto usuarioDto;
		usuarioDto = usuarioDao.encontarUsuario(username, this.loginBacking.getPassword());
		if (usuarioDto == null)
			throw new BadCredentialsException("Usuario y/o Clave Incorrectos");
		else {
			return makeAcegiUser(usuarioDto);
		}
	}

	private User makeAcegiUser(UsuarioDto user) {
		try {
			return new User(user.getLogin(), user.getPassword(), true, true, true, true, makeGrantedAuthorities(user));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
    private GrantedAuthority[] makeGrantedAuthorities(UsuarioDto user) {
        try {
            GrantedAuthority[] result = 
                new GrantedAuthority[user.getRoles().size()];
            int i = 0;
            for (String role: user.getRoles()) {
                result[i++] = new GrantedAuthorityImpl(role);
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

}
