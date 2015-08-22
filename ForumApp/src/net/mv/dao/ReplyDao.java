package net.mv.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import net.mv.domain.Forum;
import net.mv.domain.Reply;
import net.mv.util.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class ReplyDao {

	Session session = HibernateUtil.getSession();
			
	public Set<Reply> retrieveAllReplies(Forum forum) {

		Set<Reply> replies = new HashSet<Reply>();

		//Retrieve all the attributes of the object Reply
		List<Reply> allReplies = session.createCriteria(Reply.class).list();
		
		for (Reply r : allReplies) {
			if (forum.getF_id() == r.getForum().getF_id()) {
				replies.add(r);
			}
		}
				
		return replies;
	}
	
	public void createReply(Reply reply) {
		
		Transaction tx = session.beginTransaction();
		
		session.save(reply);
		
		tx.commit();
		session.close();
		
	}
		
}
