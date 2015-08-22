package net.mv.action;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.mv.domain.Forum;
import net.mv.domain.Reply;
import net.mv.domain.User;
import net.mv.service.ForumService;
import net.mv.service.ReplyService;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;
/**
 * 
 * @author Binh Pham
 * HomeAction.java
 * This class will handle all the customer's transactions (deposit, withdrawn, display Balance)
 * Alternative using files: home.jsp, struts-config.xml
 */
public class HomeAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		HttpSession session = request.getSession();
		
		ActionForward af = new ActionForward();
		af = mapping.findForward("mapToHome");
		
		DynaActionForm dynaActionForm = (DynaActionForm) form;
		
		//Get the customer in the current session
		User user = (User) session.getAttribute("user");
		
		//Get the ForumSet in the current session
		Set<Forum> forumSet = (Set<Forum>) session.getAttribute("forumSet");
		
		//Create a new Forum Service to process Forums
		ForumService forumService = new ForumService();
		
		//Get the Forum Title by the user's click
		String f_title = request.getParameter("title");
		
		//Get a Forum from DB
		Forum forum = forumService.getForum(forumSet, f_title);
		
	
		/*
		 * Check if the "Title" from userClicked is equals to the Forum Title
		 * Then set Forum to the current Forum in the session
		 */
		if (f_title.equals(forum.getTitle())) {
			
			session.setAttribute("forum", forum);
		
			
			/*Populate Set of replies to display on Forum page
			 */
			ReplyService replyService = new ReplyService();
			Set<Reply> replies = replyService.getAllReply(forum);
			session.setAttribute("replySet",  replies);
		
			af = mapping.findForward("mapToForum");
		}
		
		/*
		 * Check if the user clicks to submit a new Forum
		 * Then Create a new Forum -> Save it to DB -> Add to the
		 * Set of Forums as well
		 */
		else if (request.getParameter("addForum").equals("Add Forum")){
			
			String title = dynaActionForm.getString("title");
			String description = dynaActionForm.getString("description");
			
			//Save Forum's title, description, and created user
			forum.setTitle(title);
			forum.setF_desc(description);
			forum.setUser(user);
	
			//Save to DB and add to the Forum Set
			forumService.saveForum(forum);
			forumSet.add(forum);
			session.setAttribute("forumSet", forumSet);
		}
		/*
		 * Otherwise, logout and invalidate the session
		 */
		else
		{
			session.invalidate();
			af = mapping.findForward("mapToLogout");
		}
		 
		return af;
	}
	
}
