package net.mv.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.mv.action.form.LoginForm;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class LoginAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		System.out.println("Hello world");
		
		LoginForm loginForm = (LoginForm) form;
		String username = loginForm.getUsername();
		String password = loginForm.getPassword();
		
		System.out.println("Username: " + username);
		System.out.println("Password: " + password);
		
		ActionForward af = new ActionForward();
		
		if (username.equals("Binh") && password.equals("seattle"))
			af = mapping.findForward("loginSuccess");
		else
			af = mapping.findForward("loginFailure");
		return af;
	}
		
}
