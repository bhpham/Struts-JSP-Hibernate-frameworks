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

public class HomeAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		//BankService bank = new BankService();
		HttpSession session = request.getSession();
		Customer customer = (Customer) session.getAttribute("customer");
		bankDao bankDao = new bankDao();
		
		String transaction = request.getParameter("transaction");
		DynaActionForm dynaActionForm = (DynaActionForm) form;
		double amount = Double.parseDouble(dynaActionForm.getString("amount"));
		//bank.setBalance(customer.getCustBalance());
	
		if (transaction.equals("Deposit")) {
			
			customer.deposit(amount);
			
			//System.out.println("YOUR BALANCE 2: " + customer.getCustBalance());
			//System.out.println("customer username: " + customer.getCustUsername());
			
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
