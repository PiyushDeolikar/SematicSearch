  
package com.project.classifier4J.bayesian;   
   
import javax.naming.*;   
import javax.sql.*;   
import java.sql.*;   
   
   
public class DataSourceJDBCConnectionManager implements IJDBCConnectionManager {   
   
    String datasourceContext;   
    DataSource dataSource;   
   
    public DataSourceJDBCConnectionManager(String ctx) throws NamingException, IllegalArgumentException {   
        this.datasourceContext = ctx;   
        Context context = new InitialContext();   
        if (context == null) {   
            throw new NamingException("No JNDI Inital Context Found");   
        }   
        dataSource = (DataSource) context.lookup(datasourceContext);   
        if (dataSource == null) {   
            throw new IllegalArgumentException("Could not find datasource");   
        }   
   
    }   
   
    public String getDatasourceContext() {   
        return datasourceContext;   
    }   
   
   
    public Connection getConnection() throws SQLException {   
        return dataSource.getConnection();   
    }   
   
   
    public void returnConnection(Connection con) throws SQLException {   
        if (con != null) {   
            con.close();   
        }           
    }   
   
}  