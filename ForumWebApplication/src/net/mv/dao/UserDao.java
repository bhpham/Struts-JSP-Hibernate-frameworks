package net.mv.dao;

import java.sql.SQLException;

import net.mv.domain.User;
import net.mv.util.HibernateUtil;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserDao {

private Session session = HibernateUtil.getSession();
	
	/*
	 * Retrieve all the Customers from the table Customer in DBMS
	 */
	public User retrieveUser(String username) {
	
		//Open Transaction
		Transaction tx = session.beginTransaction();

		//Create HQL query for the session
		Query query = session.createQuery("from User where Username = :username");
		query.setParameter("username", username);
		
		//Set customer unique object
		User user = (User) query.uniqueResult();

		//Commit the transaction and close session
		tx.commit();
		session.close();
		
		return user;
	}
	
	/*
	 * Given a registered customer 
	 * Create a new customer by the registered customer's signature
	 * Then add it to DBMS
	 */
	public void createUser(User user) throws SQLException {
		Transaction tx = session.beginTransaction();
		User newUser = user;
		session.save(newUser);
		
		tx.commit();
		session.close();
	}
}
