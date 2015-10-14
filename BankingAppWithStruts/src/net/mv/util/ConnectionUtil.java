package net.mv.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

public class ConnectionUtil {

	private static ConnectionUtil util;
	

	private ConnectionUtil() throws ClassNotFoundException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
	}
	
	public static ConnectionUtil getConnectionUtil() {
		if (util == null) {
			
			try {
				util = new ConnectionUtil();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return util;
	}

	
	public Connection createConnection() {
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "admin", "admin");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public void closeConnection(Connection conn) {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}