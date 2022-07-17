/*
 * Copyright 2009. Profamilia. Todos los derechos reservados.
 * Se prohibe el uso y modificaci�n del programa sin la
 * autorizaci�n expresa de Profamilia.
 *
 * 25/03/2009
 */
package org.profamilia.hc.toolbox.auth;

import org.acegisecurity.Authentication;
import org.acegisecurity.context.SecurityContextHolder;

/**
 * Implementaci�n de {@link AuthenticationSource} que obtiene las credenciales
 * del {@link SecurityContextHolder}
 * @author Jos� Andr�s Riano
 *
 */
public class

SecurityContextAuthenticationSource implements AuthenticationSource {

    /*
	 * @see org.profamilia.hc.toolbox.auth.AuthenticationSource#getAuthentication()
	 */

    public Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

}
