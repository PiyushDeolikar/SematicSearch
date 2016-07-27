
package com.project.classifier4J.bayesian;   
   
import java.sql.Connection;   
import java.sql.DriverManager;   
import java.sql.SQLException;   
   
  
public class DriverMangerJDBCConnectionManager implements IJDBCConnectionManager {   
   
    String dbURL;   
    String dbUser;   
    String dbPassword;   
   
    public DriverMangerJDBCConnectionManager(String url, String user, String password) {   
        this.dbURL = url;   
        this.dbUser = user;   
        this.dbPassword = password;   
    }   
   
    public String getDbPassword() {   
        return dbPassword;   
    }   
   
    public String getDbURL() {   
        return dbURL;   
    }   
   
    public String getDbUser() {   
        return dbUser;   
    }   
   
    public void setDbPassword(String string) {   
        dbPassword = string;   
    }   
   
    public void setDbURL(String string) {   
        dbURL = string;   
    }   
   
    public void setDbUser(String string) {   
        dbUser = string;   
    }   
   
    
    public Connection getConnection() throws SQLException {   
        return DriverManager.getConnection(dbURL, dbUser, dbPassword);   
    }   
   
    
    public void returnConnection(Connection con) throws SQLException {   
        con.close();   
    }   
   
}