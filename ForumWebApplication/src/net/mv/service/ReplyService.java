package net.mv.service;

import java.util.Set;

import net.mv.dao.ReplyDao;
import net.mv.domain.Forum;
import net.mv.domain.Reply;

public class ReplyService {

	private ReplyDao replyDao = new ReplyDao();
	
	public Set<Reply> getAllReply(Forum forum) {
		
		return replyDao.retrieveAllReplies(forum);
	}
	
	public void saveReply(Reply reply){
		replyDao.createReply(reply);
	}

	
}
