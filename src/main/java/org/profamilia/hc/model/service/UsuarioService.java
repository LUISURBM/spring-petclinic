package org.profamilia.hc.model.service;


import org.springframework.dao.DataAccessException;
import org.acegisecurity.userdetails.UserDetails;
import org.acegisecurity.userdetails.UsernameNotFoundException;



public interface UsuarioService {

    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, 
                                                           DataAccessException;

}
