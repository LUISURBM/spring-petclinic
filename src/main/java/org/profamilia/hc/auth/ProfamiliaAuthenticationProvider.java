package org.profamilia.hc.auth;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import javax.sql.DataSource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.acegisecurity.Authentication;
import org.acegisecurity.AuthenticationException;
import org.acegisecurity.AuthenticationServiceException;
import org.acegisecurity.BadCredentialsException;
import org.acegisecurity.CredentialsExpiredException;
import org.acegisecurity.GrantedAuthority;
import org.acegisecurity.GrantedAuthorityImpl;
import org.acegisecurity.providers.AuthenticationProvider;
import org.acegisecurity.providers.UsernamePasswordAuthenticationToken;
import org.acegisecurity.userdetails.User;

public class ProfamiliaAuthenticationProvider implements AuthenticationProvider {
	private Log log;
	private String driverClassName;
	private String connectionString;
	private String userSchema;
	private int authenticationType;
	private DataSource dataSource;

	public ProfamiliaAuthenticationProvider() {
		$init$();
	}

	private void $init$() {
		this.log = LogFactory.getLog(getClass());
		this.authenticationType = 0;
	}

	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String userName = (String) authentication.getPrincipal();
		String password = (String) authentication.getCredentials();

		String[] roles = validateUser(userName, password);


        GrantedAuthority[] granted = new GrantedAuthority[roles.length];
        for (int i = 0; i < roles.length; i++) {
            granted[i] = new GrantedAuthorityImpl(roles[i]);
        }
        return new UsernamePasswordAuthenticationToken(new User(userName, 
                                                                password, true, 
                                                                true, true, 
                                                                true, granted), 
                                                       password, granted);
	}

	private String[] validateUser(String userName, String password) {
		try {
			Class.forName(this.driverClassName);
		} catch (Exception e) {
			throw new AuthenticationServiceException("ERROR cargando driver JDBC", e);
		}
		Connection connection = null;
		String[] roles = new String[0];
		try {
			connection = DriverManager.getConnection(this.connectionString, userName, password);

			roles = new String[1];
			roles[0] = "ROLE_ALLACCESS";

			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM HISTORIA.CHUSUARIO");

			ResultSet resultSet = preparedStatement.executeQuery();
			preparedStatement.close();
			resultSet.close();
		} catch (SQLException e) {
			handleLoginException(e);
		} finally {
			try {
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException localSQLException1) {
				localSQLException1.printStackTrace();
			}
		}
		return roles;
	}

	public boolean supports(Class clazz) {
		return clazz.equals(UsernamePasswordAuthenticationToken.class);
	}

	private static void handleLoginException(SQLException exception) {
		if (exception.getMessage().indexOf("ORA-28001") != -1) {
			throw new CredentialsExpiredException("La contrase�a del usuario ha expirado");
		}
		if (exception.getMessage().indexOf("ORA-01017") != -1) {
			throw new BadCredentialsException("Usuario y/o Clave Incorrectos");
		}
		if (exception.getMessage().indexOf("ORA-00942") != -1) {
			throw new BadCredentialsException(
					"No tiene permisos para ingresar a la aplicacion, favor comunicarse con el Dpto Tecnologia (Tabla o Vista no existe) ");
		}
		throw new AuthenticationServiceException(
				"Error El usuario se encuentra bloqueado. Favor comunicarse con la administradora");
	}

	public void setDriverClassName(String driverClassName) {
		this.driverClassName = driverClassName;
	}

	public void setConnectionString(String connectionString) {
		this.connectionString = connectionString;
	}

	public void setAuthenticationType(int authenticationType) {
		this.authenticationType = authenticationType;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void setUserSchema(String userSchema) {
		this.userSchema = userSchema;
	}
}
