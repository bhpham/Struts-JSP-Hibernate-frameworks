package net.mv.domain;

import net.mv.service.AcctOverdrawnException;

/**
 * @author Binh Pham
 *
 */
public class Customer {
	private long custId;
	private String custName;
	private String custUsername;
	private String custPassword;
	private double custBalance;
	private String custAge;
	private String custEmail;
	
	
	public long getCustId() {
		return custId;
	}
	public void setCustId(long custId) {
		this.custId = custId;
	}
	public String getCustName() {
		return custName;
	}
	public void setCustName(String custName) {
		this.custName = custName;
	}
	public String getCustUsername() {
		return custUsername;
	}
	public void setCustUsername(String custUsername) {
		this.custUsername = custUsername;
	}
	public String getCustPassword() {
		return custPassword;
	}
	public void setCustPassword(String custPassword) {
		this.custPassword = custPassword;
	}
	public double getCustBalance() {
		return custBalance;
	}
	public void setCustBalance(double custBalance) {
		this.custBalance = custBalance;
	}
	public String getCustAge() {
		return custAge;
	}
	public void setCustAge(String custAge) {
		this.custAge = custAge;
	}
	public String getCustEmail() {
		return custEmail;
	}
	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}
	
	
	@Override
	public String toString() {
		return "Customer [custId=" + custId + ", custName=" + custName
				+ ", custUsername=" + custUsername + ", custPassword="
				+ custPassword + ", custBalance=" + custBalance + ", custAge="
				+ custAge + ", custEmail=" + custEmail + "]";
	}
	
	public void deposit(double amount) {
		custBalance += amount;
	}
	
	public void withdrawn(double amount) {
		if (amount > custBalance|| custBalance <= 0) {
			try{
				throw new AcctOverdrawnException();
			} catch (AcctOverdrawnException ex) {
				ex.printStackTrace();
				System.out.println("Your withdrawn exceed your balance limit!");
			}
		}else
		{
			custBalance -= amount;
		}
		

	}
	
	
	
	
}
