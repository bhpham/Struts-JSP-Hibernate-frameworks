package net.mv.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import net.mv.domain.Customer;
import net.mv.util.ConnectionUtil;

public class bankDao {
	
	private ConnectionUtil util = ConnectionUtil.getConnectionUtil();
	private customerDao custDao = new customerDao();
	
	public void updateBalance(Customer customer) throws SQLException {
		
		Customer custFromDB = customer;
		
	
		/*Create a new updated query and the preparedStatement
		 * Update the SQL ACCOUNTS Table*/
		String query = "UPDATE ACCOUNTS SET BALANCE = ? WHERE USERNAME = ?";
		Connection conn = util.createConnection();
		
		try (PreparedStatement pst = conn.prepareStatement(query); ) {
			pst.setDouble(1, custFromDB.getCustBalance());
			pst.setString(2, custFromDB.getCustUsername());
			pst.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.closeConnection(conn);
		}
		
	}

}
