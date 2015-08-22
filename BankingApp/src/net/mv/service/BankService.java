package net.mv.service;

import net.mv.domain.Customer;


public class BankService {
	
	private double balance;
	
	public void deposit(double amount) {
		balance += amount;
		
	}
	
	public void withdrawn(double amount) {
		if (amount > balance|| balance <= 0) {
			try{
				throw new AcctOverdrawnException();
			} catch (AcctOverdrawnException ex) {
				ex.printStackTrace();
				System.out.println("Your withdrawn exceed your balance limit!");
			}
		}else
		{
			balance -= amount;
		}
		
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
}

