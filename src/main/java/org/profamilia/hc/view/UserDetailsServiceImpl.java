package org.profamilia.hc.view;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.acegisecurity.BadCredentialsException;
import org.acegisecurity.GrantedAuthority;
import org.acegisecurity.GrantedAuthorityImpl;
import org.acegisecurity.userdetails.UserDetails;
import org.acegisecurity.userdetails.UserDetailsService;
import org.acegisecurity.userdetails.UsernameNotFoundException;
import org.springframework.dao.DataAccessException;
import org.acegisecurity.userdetails.User;


public class UserDetailsServiceImpl implements UserDetailsService {

    private UserDao userDao;

    public UserDetailsServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, 
                                                                  DataAccessException {
        AppUser user;
        user = userDao.findUser(username);
        if (user == null)
            throw new BadCredentialsException("Usuario No Encontrado: " + 
                                              username);
        else {
            return makeAcegiUser(user);
        }
    }

    private User makeAcegiUser(AppUser user) {
        try {
            return new User(user.getLogin(), 
                                                          user.getPassword(), 
                                                          true, true, true, 
                                                          true, 
                                                          makeGrantedAuthorities(user));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    private GrantedAuthority[] makeGrantedAuthorities(AppUser user) {
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
