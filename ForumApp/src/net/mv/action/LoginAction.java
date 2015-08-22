package net.mv.action;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.mv.dao.UserDao;
import net.mv.domain.Forum;
import net.mv.domain.User;
import net.mv.service.ForumService;
import net.mv.service.UserService;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;

public class LoginAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
	
		
		DynaActionForm dynaActionForm = (DynaActionForm) form;
		String username = dynaActionForm.getString("username");
		String password = dynaActionForm.getString("password");
		
		
		User user = new User();
		
		user.setUsername(username);
		user.setPassword(password);
		
		UserService userService = new UserService();
		
		boolean authenticated = userService.AuthenticateUser(user);
		ActionForward af = new ActionForward();
		
		
		if (authenticated) {
			UserDao userDao = new UserDao();
			User userFromDB = userDao.retrieveUser(user.getUsername());
			HttpSession session = request.getSession();
			session.setAttribute("user", userFromDB);

			ForumService forumService = new ForumService();
			Set<Forum> forums = forumService.getAllForum(user);		
			session.setAttribute("forumSet",  forums);
			
			
			af = mapping.findForward("mapToHome");
		} else
			af = mapping.findForward("mapToLogin");
		
		return af;
	}
		
}
