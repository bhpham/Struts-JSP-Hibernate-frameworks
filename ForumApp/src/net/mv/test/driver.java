package net.mv.test;

import java.util.ArrayList;

import net.mv.domain.Forum;
import net.mv.domain.Reply;
import net.mv.domain.User;
import net.mv.util.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class driver {

//	public static void main(String[] args) {
//
//		User kevin = new User(1, "Kevin", "j2eeMv724", 25, "kevin@gmail.com");
//		User jason = new User(2, "Jason", "j2eeMv724", 30, "jason@gmail.com");
//		User john = new User(3, "John", "j2eeMv724", 22, "john@gmail.com");
//		
//		Forum music = new Forum(1, "Music", "Share nice music", kevin);
//		Forum video = new Forum(2, "Videos", "Share cool videos", jason);
//		Forum deals = new Forum(3, "Slickdeals", "Share good deals", john);
//		Forum news = new Forum(4, "News", "Share lastest news", kevin);
//		
//		Reply reply_1 = new Reply(1, "Mirrors by Justin Timberlake", kevin, music);
//		Reply reply_2 = new Reply(2, "Prank videos", jason, video);
//		Reply reply_3 = new Reply(3, "Shooting in Louisiana", john, news);
//	
//		
//		
//		Session session = HibernateUtil.getSession();
//		Transaction tx = session.beginTransaction();
//		
//		session.save(kevin);
//		session.save(jason);
//		session.save(john);
//		
//		
//		session.save(music);
//		session.save(video);
//		session.save(deals);
//		session.save(news);
//		
//		session.save(reply_1);
//		session.save(reply_2);
//		session.save(reply_3);
//		
//		
//		
//
//		
//		tx.commit();
//		session.close();
//		
//	}
//	
}
