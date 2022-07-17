package org.profamilia.hc.model.dao.imp;

import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

import org.profamilia.hc.model.dto.UsuarioDto;
import org.profamilia.hc.model.dao.UsuarioDao;


public class UsuarioDaoImp implements UsuarioDao {
    public UsuarioDto encontarUsuario(String userName, String password) {
        UsuarioDto usuarioDto = null;
        Set<String> roles = new HashSet<String>();
        roles.add("ROLE_ALLACCESS");

        if (this.esUsuarioValido(userName, password))
            usuarioDto = new UsuarioDto(userName, password, roles);

        return usuarioDto;
    }

    public boolean esUsuarioValido(String user, String psswd) {
        boolean usuarioValido = false;
        String driver = null;
        String url = null;
        Connection conexion = null;
        try {

            Properties props = new Properties();
            props.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("db.properties"));
            driver = props.getProperty("jdbc.driverClassName");
            url = props.getProperty("jdbc.url");

            Class.forName(driver);
            conexion = 
                    DriverManager.getConnection(url, user.toUpperCase(), psswd.toUpperCase());
            usuarioValido = true;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception es) {
            es.printStackTrace();
        } finally {
            try {
                if (conexion != null)
                    conexion.close();
            } catch (SQLException es) {
               es.printStackTrace();
            }
        }
        return usuarioValido;
    }


}
