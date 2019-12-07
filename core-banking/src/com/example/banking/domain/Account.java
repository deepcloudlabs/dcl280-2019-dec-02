package com.example.banking.domain;

import java.io.Serializable;

// Alt+Shift+S: Generate code
// Ctrl+Shift+F: Formatting code
/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
@SuppressWarnings("serial")
public class Account implements Serializable {
	private final String iban; // null
	protected double balance; // 0.0
	private transient AccountStatus status = AccountStatus.ACTIVE;

	public AccountStatus getStatus() {
		return status;
	}

	public void setStatus(AccountStatus status) {
		this.status = status;
	}

	// members: constructors, method
	public Account(final String iban, final double balance) {
		this.iban = iban;
		if (balance > 0.)
			this.balance = balance;
	}
	// members: getters/setters

	public String getIban() {
		return iban;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((iban == null) ? 0 : iban.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (iban == null) {
			if (other.iban != null)
				return false;
		} else if (!iban.equals(other.iban))
			return false;
		return true;
	}

	public double getBalance() {
		return balance;
	}

	// members: business methods
	public final void deposit(final double amount) {
		// validation
		if (amount <= 0.)
			throw new IllegalArgumentException("Amount cannot be negative!");
		// business logic
		this.balance = this.balance + amount;
	}

	public void withdraw(final double amount) throws InsufficientBalanceEception {
		System.out.println("Account::withdraw");
		// validation
		if (amount <= 0.)
			throw new IllegalArgumentException("Amount cannot be negative!");
		// business rule
		if (amount > balance)
			throw new InsufficientBalanceEception("Your balance does not cover your expenses!", amount - balance);
		// business logic
		this.balance = this.balance - amount;
	}

	@Override
	public String toString() {
		return "Account [iban=" + iban + "]";
	}

}