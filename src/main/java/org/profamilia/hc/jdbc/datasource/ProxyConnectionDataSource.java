/*
 * Copyright 2008. Profamilia. Todos los derechos reservados.
 * Se prohibe el uso y modificaci�n del programa sin la
 * autorizaci�n expresa de Profamilia.
 *
 * 25/03/2009
 */

package org.profamilia.hc.jdbc.datasource;

import java.io.PrintWriter;
import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.Struct;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;
import java.util.logging.Logger;

import javax.sql.DataSource;

// import oracle.jdbc.OracleConnection;

import org.acegisecurity.Authentication;
import org.acegisecurity.userdetails.UserDetails;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.profamilia.hc.toolbox.auth.AuthenticationSource;

import org.springframework.util.Assert;

// import weblogic.jdbc.extensions.WLConnection;


/**
 * @author Jos� Andr�s Ria�o Rinc�n 
 * @author Norbey Lis
 *
 */
public class ProxyConnectionDataSource implements DataSource {

    /** Log del datasource */
    private Log log = LogFactory.getLog(this.getClass());

    /** DataSource al cual se delega el comportamiento */
    private DataSource delegateDataSource;

    /** Fuente de donde se obtienen las credenciales del usuario actual */
    private AuthenticationSource authenticationSource;

    /** Determina si el datasource se obtiene desde una instancia de OC4J */
    private boolean isInsideOc4j;

    private static final String ANONYMOUS_USER_PRINCIPAL = "anonymousUser";

    public ProxyConnectionDataSource() {

    }

    /**
     * @see javax.sql.DataSource#getConnection()
     */
    public Connection getConnection() throws SQLException {

        Assert.notNull(delegateDataSource);
        Assert.notNull(authenticationSource);
        Connection connection = delegateDataSource.getConnection();
        log.trace("Conexion obtenida");
        // OracleConnection oracleConnection = null;
        // Connection metaDataConnection;

        // if (connection instanceof OracleConnection) {         
        
            // if(connection instanceof WLConnection){                
            //     oracleConnection = (OracleConnection)((WLConnection)connection).getVendorConnection();
            // }else{
                // oracleConnection = (OracleConnection)connection;
            // }           
            

        // } else if ((metaDataConnection = connection.getMetaData().getConnection()) instanceof OracleConnection) {            
            
            // if(connection instanceof WLConnection){                
            //     oracleConnection = (OracleConnection)((WLConnection)metaDataConnection).getVendorConnection();
            // }else{
                // oracleConnection = (OracleConnection)metaDataConnection;
            // }   
            
        // }

//         if (oracleConnection != null) {
//             Authentication authentication = 
//                 authenticationSource.getAuthentication();

//             if (authentication != null && 
//                 authentication.getPrincipal() != null) {
//                 if (!authentication.getPrincipal().equals(ANONYMOUS_USER_PRINCIPAL)) {
//                     if (!(authentication.getPrincipal() instanceof 
//                           UserDetails)) {
//                         log.error("Usuario inconsistente. Se esperada usuario de tipo " + 
//                                   UserDetails.class.getName() + 
//                                   " y se obtuvo usuario de tipo " + 
//                                   authentication.getPrincipal().getClass().getName());
//                         throw new SQLException("Invalid current user credentials");
//                     }
//                     log.trace("Abriendo conexion proxy");
//                     log.trace("Principal " + authentication.getPrincipal());
//                     log.trace("Name " + authentication.getName());
//                     UserDetails detallesUsuario = 
//                         (UserDetails)authentication.getPrincipal();

//                     if (!oracleConnection.isProxySession()) {
//                         Properties properties = new Properties();
//                         properties.put(OracleConnection.PROXY_USER_NAME, 
//                                        detallesUsuario.getUsername());

//                         oracleConnection.openProxySession(OracleConnection.PROXYTYPE_USER_NAME, 
//                                                           properties);
//                         log.trace("Conexion proxy abierta");
//                     }
//                 }
//             }

// //            connection = oracleConnection;
//         }

        return new ProxyConnectionAdapter(connection);
    }

    /**
     * @see javax.sql.DataSource#getConnection(java.lang.String, java.lang.String)
     */
    public Connection getConnection(String username, 
                                    String password) throws SQLException {
        return delegateDataSource.getConnection(username, password);
    }

    /**
     * @see javax.sql.CommonDataSource#getLogWriter()
     */
    public PrintWriter getLogWriter() throws SQLException {
        return delegateDataSource.getLogWriter();
    }

    /**
     * @see javax.sql.CommonDataSource#getLoginTimeout()
     */
    public int getLoginTimeout() throws SQLException {
        return delegateDataSource.getLoginTimeout();
    }

    /**
     * @see javax.sql.CommonDataSource#setLogWriter(java.io.PrintWriter)
     */
    public void setLogWriter(PrintWriter out) throws SQLException {
        delegateDataSource.setLogWriter(out);
    }

    /**
     * @see javax.sql.CommonDataSource#setLoginTimeout(int)
     */
    public void setLoginTimeout(int seconds) throws SQLException {
        delegateDataSource.setLoginTimeout(seconds);
    }

    private class ProxyConnectionAdapter implements Connection {

        private Connection delegateConnection;

        public ProxyConnectionAdapter(Connection delegateConnection) {
            this.delegateConnection = delegateConnection;
        }

        /**
         * @throws SQLException
         * @see java.sql.Connection#clearWarnings()
         */
        public void clearWarnings() throws SQLException {
            delegateConnection.clearWarnings();
        }

public int getNetworkTimeout() throws SQLException {
  return delegateConnection.getNetworkTimeout();
}
       
        /**
                 * @throws SQLException
                 * @see java.sql.Connection#close()
                 */
                public void close() throws SQLException {
         
                    // if (delegateConnection instanceof OracleConnection) {
                    //     OracleConnection oracleConnection =
                    //         (OracleConnection)delegateConnection;
                    //     if (oracleConnection.isProxySession()) {
                    //         oracleConnection.close(OracleConnection.PROXYTYPE_USER_NAME);
                    //      }
                    // }else{
                        // org.jboss.resource.adapter.jdbc.jdk6.WrappedConnectionJDK6 c  = (org.jboss.resource.adapter.jdbc.jdk6.WrappedConnectionJDK6)delegateConnection;
                        // OracleConnection oracleConnection =(OracleConnection) c.getUnderlyingConnection() ;
                        // if (oracleConnection.isProxySession()) {
                            // oracleConnection.close(OracleConnection.PROXYTYPE_USER_NAME);
                    //    }
                    // }
         
                   this.delegateConnection.close();
                   log.trace("Conexion Cerrada");
                }

        /**
         * @throws SQLException
         * @see java.sql.Connection#commit()
         */
        public void commit() throws SQLException {
            delegateConnection.commit();
        }

        /**
         * @return
         * @throws SQLException
         * @see java.sql.Connection#createStatement()
         */
        public Statement createStatement() throws SQLException {
            return delegateConnection.createStatement();
        }

        /**
         * @param resultSetType
         * @param resultSetConcurrency
         * @param resultSetHoldability
         * @return
         * @throws SQLException
         * @see java.sql.Connection#createStatement(int, int, int)
         */
        public Statement createStatement(int resultSetType, 
                                         int resultSetConcurrency, 
                                         int resultSetHoldability) throws SQLException {
            return delegateConnection.createStatement(resultSetType, 
                                                      resultSetConcurrency, 
                                                      resultSetHoldability);
        }

        /**
         * @param resultSetType
         * @param resultSetConcurrency
         * @return
         * @throws SQLException
         * @see java.sql.Connection#createStatement(int, int)
         */
        public Statement createStatement(int resultSetType, 
                                         int resultSetConcurrency) throws SQLException {
            return delegateConnection.createStatement(resultSetType, 
                                                      resultSetConcurrency);
        }

        /**
         * @return
         * @throws SQLException
         * @see java.sql.Connection#getAutoCommit()
         */
        public boolean getAutoCommit() throws SQLException {
            return delegateConnection.getAutoCommit();
        }

        /**
         * @return
         * @throws SQLException
         * @see java.sql.Connection#getCatalog()
         */
        public String getCatalog() throws SQLException {
            return delegateConnection.getCatalog();
        }

        /**
         * @return
         * @throws SQLException
         * @see java.sql.Connection#getHoldability()
         */
        public int getHoldability() throws SQLException {
            return delegateConnection.getHoldability();
        }

        /**
         * @return
         * @throws SQLException
         * @see java.sql.Connection#getMetaData()
         */
        public DatabaseMetaData getMetaData() throws SQLException {
            return delegateConnection.getMetaData();
        }

        /**
         * @return
         * @throws SQLException
         * @see java.sql.Connection#getTransactionIsolation()
         */
        public int getTransactionIsolation() throws SQLException {
            return delegateConnection.getTransactionIsolation();
        }

        /**
         * @return
         * @throws SQLException
         * @see java.sql.Connection#getTypeMap()
         */
        public Map<String, Class<?>> getTypeMap() throws SQLException {
            return delegateConnection.getTypeMap();
        }

        /**
         * @return
         * @throws SQLException
         * @see java.sql.Connection#getWarnings()
         */
        public SQLWarning getWarnings() throws SQLException {
            return delegateConnection.getWarnings();
        }

        /**
         * @return
         * @throws SQLException
         * @see java.sql.Connection#isClosed()
         */
        public boolean isClosed() throws SQLException {
            return delegateConnection.isClosed();
        }

        /**
         * @return
         * @throws SQLException
         * @see java.sql.Connection#isReadOnly()
         */
        public boolean isReadOnly() throws SQLException {
            return delegateConnection.isReadOnly();
        }

        /**
         * @param sql
         * @return
         * @throws SQLException
         * @see java.sql.Connection#nativeSQL(java.lang.String)
         */
        public String nativeSQL(String sql) throws SQLException {
            return delegateConnection.nativeSQL(sql);
        }

        /**
         * @param sql
         * @param resultSetType
         * @param resultSetConcurrency
         * @param resultSetHoldability
         * @return
         * @throws SQLException
         * @see java.sql.Connection#prepareCall(java.lang.String, int, int, int)
         */
        public CallableStatement prepareCall(String sql, int resultSetType, 
                                             int resultSetConcurrency, 
                                             int resultSetHoldability) throws SQLException {
            return delegateConnection.prepareCall(sql, resultSetType, 
                                                  resultSetConcurrency, 
                                                  resultSetHoldability);
        }

        /**
         * @param sql
         * @param resultSetType
         * @param resultSetConcurrency
         * @return
         * @throws SQLException
         * @see java.sql.Connection#prepareCall(java.lang.String, int, int)
         */
        public CallableStatement prepareCall(String sql, int resultSetType, 
                                             int resultSetConcurrency) throws SQLException {
            return delegateConnection.prepareCall(sql, resultSetType, 
                                                  resultSetConcurrency);
        }

        /**
         * @param sql
         * @return
         * @throws SQLException
         * @see java.sql.Connection#prepareCall(java.lang.String)
         */
        public CallableStatement prepareCall(String sql) throws SQLException {
            return delegateConnection.prepareCall(sql);
        }

        /**
         * @param sql
         * @param resultSetType
         * @param resultSetConcurrency
         * @param resultSetHoldability
         * @return
         * @throws SQLException
         * @see java.sql.Connection#prepareStatement(java.lang.String, int, int, int)
         */
        public PreparedStatement prepareStatement(String sql, 
                                                  int resultSetType, 
                                                  int resultSetConcurrency, 
                                                  int resultSetHoldability) throws SQLException {
            return delegateConnection.prepareStatement(sql, resultSetType, 
                                                       resultSetConcurrency, 
                                                       resultSetHoldability);
        }

        /**
         * @param sql
         * @param resultSetType
         * @param resultSetConcurrency
         * @return
         * @throws SQLException
         * @see java.sql.Connection#prepareStatement(java.lang.String, int, int)
         */
        public PreparedStatement prepareStatement(String sql, 
                                                  int resultSetType, 
                                                  int resultSetConcurrency) throws SQLException {
            return delegateConnection.prepareStatement(sql, resultSetType, 
                                                       resultSetConcurrency);
        }

        /**
         * @param sql
         * @param autoGeneratedKeys
         * @return
         * @throws SQLException
         * @see java.sql.Connection#prepareStatement(java.lang.String, int)
         */
        public PreparedStatement prepareStatement(String sql, 
                                                  int autoGeneratedKeys) throws SQLException {
            return delegateConnection.prepareStatement(sql, autoGeneratedKeys);
        }

        /**
         * @param sql
         * @param columnIndexes
         * @return
         * @throws SQLException
         * @see java.sql.Connection#prepareStatement(java.lang.String, int[])
         */
        public PreparedStatement prepareStatement(String sql, 
                                                  int[] columnIndexes) throws SQLException {
            return delegateConnection.prepareStatement(sql, columnIndexes);
        }

        /**
         * @param sql
         * @param columnNames
         * @return
         * @throws SQLException
         * @see java.sql.Connection#prepareStatement(java.lang.String, java.lang.String[])
         */
        public PreparedStatement prepareStatement(String sql, 
                                                  String[] columnNames) throws SQLException {
            return delegateConnection.prepareStatement(sql, columnNames);
        }

        /**
         * @param sql
         * @return
         * @throws SQLException
         * @see java.sql.Connection#prepareStatement(java.lang.String)
         */
        public PreparedStatement prepareStatement(String sql) throws SQLException {
            return delegateConnection.prepareStatement(sql);
        }

        /**
         * @param savepoint
         * @throws SQLException
         * @see java.sql.Connection#releaseSavepoint(java.sql.Savepoint)
         */
        public void releaseSavepoint(Savepoint savepoint) throws SQLException {
            delegateConnection.releaseSavepoint(savepoint);
        }

        /**
         * @throws SQLException
         * @see java.sql.Connection#rollback()
         */
        public void rollback() throws SQLException {
            delegateConnection.rollback();
        }

        /**
         * @param savepoint
         * @throws SQLException
         * @see java.sql.Connection#rollback(java.sql.Savepoint)
         */
        public void rollback(Savepoint savepoint) throws SQLException {
            delegateConnection.rollback(savepoint);
        }

        /**
         * @param autoCommit
         * @throws SQLException
         * @see java.sql.Connection#setAutoCommit(boolean)
         */
        public void setAutoCommit(boolean autoCommit) throws SQLException {
            delegateConnection.setAutoCommit(autoCommit);
        }

        /**
         * @param catalog
         * @throws SQLException
         * @see java.sql.Connection#setCatalog(java.lang.String)
         */
        public void setCatalog(String catalog) throws SQLException {
            delegateConnection.setCatalog(catalog);
        }

        /**
         * @param holdability
         * @throws SQLException
         * @see java.sql.Connection#setHoldability(int)
         */
        public void setHoldability(int holdability) throws SQLException {
            delegateConnection.setHoldability(holdability);
        }

        /**
         * @param readOnly
         * @throws SQLException
         * @see java.sql.Connection#setReadOnly(boolean)
         */
        public void setReadOnly(boolean readOnly) throws SQLException {
            delegateConnection.setReadOnly(readOnly);
        }

        /**
         * @return
         * @throws SQLException
         * @see java.sql.Connection#setSavepoint()
         */
        public Savepoint setSavepoint() throws SQLException {
            return delegateConnection.setSavepoint();
        }

        /**
         * @param name
         * @return
         * @throws SQLException
         * @see java.sql.Connection#setSavepoint(java.lang.String)
         */
        public Savepoint setSavepoint(String name) throws SQLException {
            return delegateConnection.setSavepoint(name);
        }

        /**
         * @param level
         * @throws SQLException
         * @see java.sql.Connection#setTransactionIsolation(int)
         */
        public void setTransactionIsolation(int level) throws SQLException {
            delegateConnection.setTransactionIsolation(level);
        }

        /**
         * @param map
         * @throws SQLException
         * @see java.sql.Connection#setTypeMap(java.util.Map)
         */
        public void setTypeMap(Map<String, Class<?>> map) throws SQLException {
            delegateConnection.setTypeMap(map);
        }

		
		public <T> T unwrap(Class<T> iface) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		
		public boolean isWrapperFor(Class<?> iface) throws SQLException {
			// TODO Auto-generated method stub
			return false;
		}

		
		public Clob createClob() throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		
		public Blob createBlob() throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		
		public NClob createNClob() throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		
		public SQLXML createSQLXML() throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		
		public boolean isValid(int timeout) throws SQLException {
			// TODO Auto-generated method stub
			return false;
		}

		
		public void setClientInfo(String name, String value) throws SQLClientInfoException {
			// TODO Auto-generated method stub
			
		}

		
		public void setClientInfo(Properties properties) throws SQLClientInfoException {
			// TODO Auto-generated method stub
			
		}

		
		public String getClientInfo(String name) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		
		public Properties getClientInfo() throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		
		public Array createArrayOf(String typeName, Object[] elements) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		
		public Struct createStruct(String typeName, Object[] attributes) throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		
		public void setSchema(String schema) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		
		public String getSchema() throws SQLException {
			// TODO Auto-generated method stub
			return null;
		}

		
		public void abort(Executor executor) throws SQLException {
			// TODO Auto-generated method stub
			
		}

		
		public void setNetworkTimeout(Executor executor, int milliseconds) throws SQLException {
			// TODO Auto-generated method stub
			
		}
    }

    /**
     * @param delegateDataSource the delegateDataSource to set
     */
    public void setDelegateDataSource(DataSource delegateDataSource) {
        this.delegateDataSource = delegateDataSource;
    }

    /**
     * @param authenticationSource the authenticationSource to set
     */
    public void setAuthenticationSource(AuthenticationSource authenticationSource) {
        this.authenticationSource = authenticationSource;
    }

    /**
     * @param isInsideOc4j the isInsideOc4j to set
     */
    public void setInsideOc4j(boolean isInsideOc4j) {
        this.isInsideOc4j = isInsideOc4j;
    }

	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}

	
	public <T> T unwrap(Class<T> iface) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}
}

