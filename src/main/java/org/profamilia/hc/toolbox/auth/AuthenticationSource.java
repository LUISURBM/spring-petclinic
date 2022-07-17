/*
 * Copyright 2009. Profamilia. Todos los derechos reservados.
 * Se prohibe el uso y modificaci�n del programa sin la
 * autorizaci�n expresa de Profamilia.
 *
 * 02/04/2009
 */
package org.profamilia.hc.toolbox.auth;

import org.acegisecurity.Authentication;
import org.acegisecurity.context.SecurityContextHolder;

/**
 * <p>
 * Interfaz que permite permite obtener la informaci�n del usuario autenticado
 * sin necesidad de recurrir a la llamada del singleton {@link SecurityContextHolder}
 * de Acegi. 
 * </p><p>
 * La raz�n por la cual es recomendable utilizar esta interfaz es porque facilita
 * la realizaci�n de pruebas unitarias sobre objetos que requieren acceder al
 * usuario autenticado.
 * </p>
 *@author Jos� Andr�s Riano
 *
 */
public interface

AuthenticationSource {

    /**
     * Retorna el usuario actual de la aplicaci�n.
     * @return usuario autenticado
     */
    public Authentication getAuthentication();

}
