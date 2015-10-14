package net.mv.service;

import java.sql.SQLException;

import net.mv.dao.customerDao;
import net.mv.domain.Customer;

public class CustomerService {
	
	private customerDao custDao = new customerDao();
	
	public boolean AuthenticateCustomer(Customer customer) {
		
		boolean authenticated = false;
		Customer custDB = custDao.retrieveCustomer(customer.getCustUsername());
		/*
		 * retrieve all the Customers and check password and Username
		 */
		if(custDB != null && custDB.getCustPassword().equals(customer.getCustPassword())){
			authenticated = true;
			customer.setCustId(custDB.getCustId());
		}
		
		return authenticated;
	}
	
	public boolean registerdCustomer(Customer customer) {
		boolean exists = false;
		
		try {
			custDao.createUser(customer);
		} catch (SQLException e) {
			e.printStackTrace();
			exists = true;
		}
		
		return exists;
	}
	
}
