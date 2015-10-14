package net.mv.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.mv.dao.customerDao;
import net.mv.domain.Customer;
import net.mv.service.CustomerService;

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
		String custUsername = dynaActionForm.getString("username");
		String custPassword = dynaActionForm.getString("password");
		System.out.println("Username: " + custUsername);
		System.out.println("Password: " + custPassword);
		
		Customer customer = new Customer();
		
		customer.setCustUsername(custUsername);
		customer.setCustPassword(custPassword);
		
		CustomerService customerService = new CustomerService();
		
		boolean authenticated = customerService.AuthenticateCustomer(customer);
		ActionForward af = new ActionForward();
		
		
		if (authenticated) {
			customerDao custDao = new customerDao();
			Customer custDB = custDao.retrieveCustomer(customer.getCustUsername());
			HttpSession session = request.getSession();
			session.setAttribute("customer", custDB);
		
			af = mapping.findForward("mapToHome");
		} else
			af = mapping.findForward("mapToLogin");
		
		return af;
	}
		
}
