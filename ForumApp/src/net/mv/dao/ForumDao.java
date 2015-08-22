package net.mv.dao;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import net.mv.domain.Forum;
import net.mv.domain.User;
import net.mv.util.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class ForumDao {

	private Session session = HibernateUtil.getSession();	
	
	public void createForum(Forum forum) {
		
		Transaction tx = session.beginTransaction();
		
		session.save(forum);
		
		tx.commit();
		session.close();
		
	}
	
	public Set<Forum> retrieveAllForum(User user) {

		Set<Forum> forums = new HashSet<Forum>();

		//Retrieve all the attributes of the object Forum
		List<Forum> allForums = session.createCriteria(Forum.class).list();
		
		for (Forum f : allForums) {
			forums.add(f);
		}
				
		return forums;
	}
	
	
}
