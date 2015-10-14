package net.mv.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.mv.action.form.RegisterForm;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class RegisterAction extends Action {

	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		RegisterForm registerForm = (RegisterForm) form;
		
		String username = registerForm.getUsername();
		String password = registerForm.getPassword();
		String age = registerForm.getAge();
		
		System.out.println("Username: " + username);
		System.out.println("Password: " + password);
		System.out.println("Age: " + age);
		
		
		
		return mapping.findForward("registerSuccess");
	}
	
}
