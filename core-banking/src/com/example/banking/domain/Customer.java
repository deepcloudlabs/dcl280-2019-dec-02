package com.example.banking.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
@SuppressWarnings("serial")
public class Customer implements Serializable {
	private final String identityNo;
	private String fullName;
	private final List<Account> accounts;

	public Customer(String identityNo, String fullName) {
		this.identityNo = identityNo;
		this.fullName = fullName;
		accounts = new ArrayList<>();
	}

	public String getIdentityNo() {
		return identityNo;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int getNumberOfAccounts() {
		return accounts.size();
	}

	public Account getAccount(int index) {
		return accounts.get(index);
	}

	public Optional<Account> getAccount(String iban) {
		for (Account acc : accounts)
			if (acc.getIban().equals(iban))
				return Optional.of(acc);
		return Optional.empty();
	}

	public void addAccount(Account acc) {
		this.accounts.add(acc);
	}

	public Optional<Account> removeAccount(int index) {
		try {
			Account acc = accounts.get(index);
			return removeAccount(acc);
		} catch (IndexOutOfBoundsException e) {
			return Optional.empty();
		}
	}

	public Optional<Account> removeAccount(Account account) {
		if (accounts.remove(account))
			return Optional.of(account);
		return Optional.empty();
	}

	public Optional<Account> removeAccount(String iban) {
		Optional<Account> account = getAccount(iban);
		account.ifPresent(acc -> accounts.remove(acc));
		return account;
	}

	public double getBalance() {
		double totalBalance = 0.;
		for (Iterator<Account> iter = accounts.iterator(); iter.hasNext();) {
			Account acc = iter.next();
			totalBalance += acc.getBalance();
		}
		return totalBalance;
	}

	public double getBalance5() {
		double totalBalance = 0.;
		for (Account acc : accounts)
			totalBalance += acc.getBalance();
		return totalBalance;
	}

	public double getBalance8() {
		return accounts.stream().mapToDouble(Account::getBalance).sum();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((identityNo == null) ? 0 : identityNo.hashCode());
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
		Customer other = (Customer) obj;
		if (identityNo == null) {
			if (other.identityNo != null)
				return false;
		} else if (!identityNo.equals(other.identityNo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Customer [identityNo=" + identityNo + ", fullName=" + fullName + "]";
	}

}
