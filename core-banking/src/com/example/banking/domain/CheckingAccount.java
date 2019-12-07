package com.example.banking.domain;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
@SuppressWarnings("serial")
public class CheckingAccount extends Account {
	private double overdraftAmount;

	public CheckingAccount(String iban, double balance, double overdraftAmount) {
		super(iban, balance);
		this.overdraftAmount = overdraftAmount;
	}

	public double getOverdraftAmount() {
		return overdraftAmount;
	}

	@Override
	public void withdraw(double amount) throws InsufficientBalanceEception {
		System.out.println("CheckingAccount::withdraw");

		// validation
		if (amount <= 0.)
			throw new IllegalArgumentException("Amount cannot be negative!");
		// business rule
		if (amount > (balance + overdraftAmount))
			throw new InsufficientBalanceEception("Your balance does not cover your expenses!",
					amount - balance - overdraftAmount); // business logic
		this.balance = this.balance - amount;
	}

}
