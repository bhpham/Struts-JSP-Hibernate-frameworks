package net.mv.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import net.mv.service.AcctOverdrawnException;

/**
 * @author Binh Pham
 *
 */
@Entity
public class Customer {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqcustIDKey")
	@SequenceGenerator(name = "seqcustIDKey", sequenceName = "SEQ_CUSTID_KEY", allocationSize = 1)
	private long custId;
	
	@Column(name="name")
	private String custName;
	
	@Column(name="username", unique=true)
	private String custUsername;
	
	@Column(name="password")
	private String custPassword;
	
	@Column(name="balance")
	private double custBalance;
	
	@Column(name="age")
	private String custAge;
	
	@Column(name="email")
	private String custEmail;
	
	
	
	public Customer() {}
	
	public Customer(long custId, String custName, String custUsername,
			String custPassword, double custBalance, String custAge,
			String custEmail) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.custUsername = custUsername;
		this.custPassword = custPassword;
		this.custBalance = custBalance;
		this.custAge = custAge;
		this.custEmail = custEmail;
	}
	
	
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
