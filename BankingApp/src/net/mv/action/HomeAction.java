package net.mv.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.mv.dao.bankDao;
import net.mv.domain.Customer;
import net.mv.service.BankService;

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
		
		//Get the customer in the current session
		Customer customer = (Customer) session.getAttribute("customer");
		
		//Declare a new bankDao object to update the balance after transactions
		bankDao bankDao = new bankDao();
		
		//Get values from the parameter transaction which classify in home.jsp
		//with the attributes name="transaction"
		String transaction = request.getParameter("transaction");
		
		DynaActionForm dynaActionForm = (DynaActionForm) form;
		double amount = Double.parseDouble(dynaActionForm.getString("amount"));
		
	
		/*
		 * Figure the customer transactions's request
		 * 1)Deposit or Withdrawn 
		 * 2)Update the balance in the table
		 * 3)Set balance in current session to actively display to customer on homepage
		 */
		if (transaction.equals("Deposit")) {
			
			customer.deposit(amount);
			bankDao.updateBalance(customer);
			session.setAttribute("balance", customer);
			
		} else {
			customer.withdrawn(amount);
			bankDao.updateBalance(customer);
			session.setAttribute("balance", customer);
		}
		
		
		return mapping.findForward("mapToHome");
	}
	
}
