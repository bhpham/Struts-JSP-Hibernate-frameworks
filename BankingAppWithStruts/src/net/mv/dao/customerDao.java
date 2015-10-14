package net.mv.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import net.mv.domain.Customer;
import net.mv.util.ConnectionUtil;


public class customerDao {
	
	private ConnectionUtil util = ConnectionUtil.getConnectionUtil();
	
	public Customer retrieveCustomer(String username) {
		
		Customer customer = null;
		
		String query = "SELECT * FROM ACCOUNTS WHERE USERNAME = ?";
		
		Connection conn = util.createConnection();
		
		try (PreparedStatement pst = conn.prepareStatement(query); ) {
			pst.setString(1, username);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()){
				customer = new Customer();
				
				customer.setCustId(rs.getLong("c_id"));
				customer.setCustName(rs.getString("name"));
				customer.setCustUsername(rs.getString("username"));
				customer.setCustPassword(rs.getString("password"));
				customer.setCustBalance(rs.getDouble("balance"));
				customer.setCustAge(rs.getString("age"));
				customer.setCustEmail(rs.getString("email"));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			util.closeConnection(conn);
		}
		
		return customer;
	}
	
	public void createUser(Customer customer) throws SQLException {
		
		String query = "INSERT INTO ACCOUNTS (NAME, USERNAME, PASSWORD, BALANCE, AGE, EMAIL) VALUES(?,?,?,?,?,?)";
		
		Connection conn = util.createConnection();
		
		try(PreparedStatement pst = conn.prepareStatement(query);){
			
			pst.setString(1, customer.getCustName());
			pst.setString(2, customer.getCustUsername());
			pst.setString(3, customer.getCustPassword());
			pst.setDouble(4, customer.getCustBalance());
			pst.setString(5, customer.getCustAge());
			pst.setString(6, customer.getCustEmail());
			
			pst.executeUpdate();
			
		}finally{
			util.closeConnection(conn);
		}
	}

}
