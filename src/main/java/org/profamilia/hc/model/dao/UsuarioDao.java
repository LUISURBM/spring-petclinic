package org.profamilia.hc.model.dao;

import org.profamilia.hc.model.dto.UsuarioDto;


public interface UsuarioDao {
    UsuarioDto encontarUsuario(String username, String password);
}
