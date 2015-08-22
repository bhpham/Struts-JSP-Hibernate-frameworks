package net.mv.service;

import java.util.Set;

import net.mv.dao.ForumDao;
import net.mv.domain.Forum;
import net.mv.domain.User;

public class ForumService {
	private ForumDao forumDao = new ForumDao();
	
	
	public Set<Forum> getAllForum(User user) {
		
		return forumDao.retrieveAllForum(user);
	}
	
	public void saveForum(Forum forum){
		forumDao.createForum(forum);
	}
	
	/*
	 * Traverse through the Set of Forums and get the found Forum
	 */
	public Forum getForum(Set<Forum> forumSet, String title) {
		
		Forum forum = new Forum();
		for (Forum f : forumSet) {
			if (f.getTitle().equals(title))
				forum = f;
		}
		
		return forum;
	}
}
