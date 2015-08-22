package net.mv.action;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.mv.domain.Forum;
import net.mv.domain.Reply;
import net.mv.service.ReplyService;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;

public class ForumAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		System.out.println("ACCESS FORUM ACTION");
		HttpSession session = request.getSession();
		
		ActionForward af = new ActionForward();
		
		ReplyService replyService = new ReplyService();
		
		//Get the Forum after user clicked
		Forum forum = (Forum) session.getAttribute("forum");

		//Get the set of replies in current Forum
		Set<Reply> replies = (Set<Reply>) session.getAttribute("replySet");
		
		//Declare a new reply
		Reply reply = new Reply();
		DynaActionForm dynaActionForm = (DynaActionForm) form;
		
		if (request.getParameter("addReply").equals("Add Reply")){
			
			String createReply = dynaActionForm.getString("createReply");
			
			//Save Reply's title, description, and created user
			reply.setR_desc(createReply);
			reply.setForum(forum);
			reply.setUser(forum.getUser());
			
			//Save to DB and add to the Replies Set
			replyService.saveReply(reply);
			replies.add(reply);
		
			session.setAttribute("replySet", replies);
		}
		
		af = mapping.findForward("mapToForum");
		
		return af;
	
	}
}
