/*
 * Copyright 2009. Profamilia. Todos los derechos reservados.
 * Se prohibe el uso y modificaci�n del programa sin la
 * autorizaci�n expresa de Profamilia.
 *
 * 02/04/2009
 */
package org.profamilia.hc.toolbox.auth;


import org.acegisecurity.Authentication;
import org.acegisecurity.AuthenticationException;
import org.acegisecurity.AuthenticationManager;
import org.acegisecurity.providers.AuthenticationProvider;

/**
 * Implementaci�n de {@link AuthenticationProvider} para proporcionar detalles
 * de autenticaci�n.
 * <p>
 * Esta implementaci�n delega la autenticaci�n a un
 * {@link AuthenticationManager} y retorna el objeto Authentication, eliminando
 * la informaci�n del password, para evitar que viaje de regreso al cliente en
 * texto claro.
 * 
 * @author Jos� Andr�s Riano
 */
public class

JSFAuthenticationProvider implements AuthenticationProvider {

    /** AuthenticationManager al que se delega */
    private AuthenticationManager authenticationManager;

    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        Authentication auth = 
            authenticationManager.authenticate(authentication);

        return auth;

    }

    /**
     * {@inheritDoc}
     */
    public boolean supports(Class authentication) {
        return Authentication.class.isAssignableFrom(authentication);
    }

    /**
     * Retorna el AuthenticationManager al que se delega la autenticaci�n.
     * @return Retorna el valor del campo authenticationManager
     */
    public AuthenticationManager getAuthenticationManager() {
        return authenticationManager;
    }

    /**
     * Modifica el AuthenticationManager al que se delega la autenticaci�n.
     * @param authManager Nuevo valor a asignar al campo authenticationManager
     */
    public void setAuthenticationManager(AuthenticationManager authManager) {
        this.authenticationManager = authManager;
    }

}

