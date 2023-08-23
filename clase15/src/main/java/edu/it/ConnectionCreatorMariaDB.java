package edu.it;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class ConnectionCreatorMariaDB implements ConnectionCreator {
	
	public Connection crearConexion() {
		try {
			Class.forName ("org.mariadb.jdbc.Driver");
			var connStr = "jdbc:mariadb://localhost:3306/java_lu_mi_noche";
			var conn = java.sql.DriverManager.getConnection(connStr, "root", "");
			
			return conn;
		}
		catch (SQLException ex) {
			throw new RuntimeException(ex.getMessage());
		}
		catch (Exception ex) {			
			throw new RuntimeException(ex.getMessage());
		}
	}

}
