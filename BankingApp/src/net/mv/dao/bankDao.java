package net.mv.dao;

import java.sql.SQLException;

import net.mv.domain.Customer;
import net.mv.util.HibernateUtil;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class bankDao {
	
	private Session session = HibernateUtil.getSession();

	/*
	 * Using a current customer as parameter and update the balance with corresponding
	 * customer's ID in the table Customer in DBMS
	 */
	public void updateBalance(Customer customer) throws SQLException {
		
		Transaction tx = session.beginTransaction();
		
		//Set current customer by using customer parameter
		Customer custFromDB = customer;
		
		//Create HQL query to update balance corresponding the customer's Id
		Query query = session.createQuery("UPDATE Customer set balance = :current_balance " + "WHERE id = :c_id");
		query.setParameter("current_balance", custFromDB.getCustBalance());
		query.setParameter("c_id", custFromDB.getCustId());
		
		//Execute and update the table
		query.executeUpdate();
		
		tx.commit();
		session.close();
	}

}
