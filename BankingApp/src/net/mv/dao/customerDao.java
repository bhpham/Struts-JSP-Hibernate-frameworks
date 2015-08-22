package net.mv.dao;


import java.sql.SQLException;

import net.mv.domain.Customer;
import net.mv.util.HibernateUtil;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class customerDao {
	
	private Session session = HibernateUtil.getSession();
	
	/*
	 * Retrieve all the Customers from the table Customer in DBMS
	 */
	public Customer retrieveCustomer(String username) {
	
		//Open Transaction
		Transaction tx = session.beginTransaction();

		//Create HQL query for the session
		Query query = session.createQuery("from Customer where Username = :username");
		query.setParameter("username", username);
		
		//Set customer unique object
		Customer customer = (Customer) query.uniqueResult();

		//Commit the transaction and close session
		tx.commit();
		session.close();
		
		return customer;
	}
	
	/*
	 * Given a registered customer 
	 * Create a new customer by the registered customer's signature
	 * Then add it to DBMS
	 */
	public void createUser(Customer customer) throws SQLException {
		Transaction tx = session.beginTransaction();
		Customer newCustomer = customer;
		session.save(newCustomer);
		
		tx.commit();
		session.close();
	}

}
