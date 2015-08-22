package net.mv.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.mv.domain.User;
import net.mv.service.UserService;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;

public class RegisterAction extends Action {

	/**
	 * 
	 * 
	 */
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		DynaActionForm dynaActionForm = (DynaActionForm) form;
		String username = dynaActionForm.getString("username");
		String password = dynaActionForm.getString("password");
		String confirmPass = dynaActionForm.getString("confirmPass");
		String age = dynaActionForm.getString("age");
		String email = dynaActionForm.getString("email");
		
		
		
		User user = new User();
		

		user.setAge(Integer.parseInt(age));
		user.setEmail(email);
		user.setPassword(password);
		user.setUsername(username);
		
		UserService userService = new UserService();
		boolean exists = userService.registerdUser(user);
		ActionForward af = new ActionForward();
		
		if(!exists)
			af = mapping.findForward("mapToLogin");
		else
			af = mapping.findForward("mapToRegister");
		
		return af;
	}
	
}
