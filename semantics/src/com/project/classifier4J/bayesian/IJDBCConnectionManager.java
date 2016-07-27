

package com.project.classifier4J.bayesian;   
   
import java.sql.Connection;   
import java.sql.SQLException;   
   
   
public interface IJDBCConnectionManager {   
   
    public Connection getConnection() throws SQLException;   
    public void returnConnection(Connection con) throws SQLException; 
}