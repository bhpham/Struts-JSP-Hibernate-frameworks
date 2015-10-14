package net.mv.action.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class RegisterForm extends ActionForm {

	private String username;
	private String password;
	private String age;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	
	@Override
	public ActionErrors validate(ActionMapping mapping,
			HttpServletRequest request)  throws NumberFormatException {
		
		ActionErrors actionErrors = new ActionErrors();
		
		if (username == null || username.length() < 1) {
			actionErrors.add("usernameErrorField", new ActionMessage("error.username"));
		}
		
		if (password == null || password.length() < 6) {
			actionErrors.add("passwordErrorField", new ActionMessage("error.password"));
		}
		
		try {
			if (Integer.parseInt(age) < 18)
				actionErrors.add("ageErrorField", new ActionMessage("error.age"));
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		
		
		
		return actionErrors;
	}
	
}
