package net.mv.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.mv.domain.Customer;
import net.mv.service.CustomerService;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;

public class RegisterAction extends Action {

	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		DynaActionForm dynaActionForm = (DynaActionForm) form;
		String custUsername = dynaActionForm.getString("username");
		String custPassword = dynaActionForm.getString("password");
		String custName = dynaActionForm.getString("name");
		String custAge = dynaActionForm.getString("age");
		String custEmail = dynaActionForm.getString("email");
		
		System.out.println("Username: " + custUsername);
		System.out.println("Password: " + custPassword);
		System.out.println("Password: " + custName);
		System.out.println("age: " + custUsername);
		System.out.println("email: " + custPassword);
		
		Customer customer = new Customer();
		
		customer.setCustUsername(custUsername);
		customer.setCustPassword(custPassword);
		customer.setCustBalance(1000.0);
		customer.setCustName(custName);
		customer.setCustAge(custAge);
		customer.setCustEmail(custEmail);
		
		CustomerService customerService = new CustomerService();
		
		boolean exists = customerService.registerdCustomer(customer);
		ActionForward af = new ActionForward();
		
		if(!exists)
			af = mapping.findForward("mapToLogin");
		else
			af = mapping.findForward("mapToRegister");
		
		return af;
	}
	
}
