package com.example.banking.app;

import com.example.banking.domain.Account;
import com.example.banking.domain.InsufficientBalanceEception;

// Ctrl+Shift+O : Organize imports
// Application, Executable Class
/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
@SuppressWarnings("static-access")
public class AccountApp {
	public static void main(String[] args) throws InsufficientBalanceEception {
		Account myAcc = null;
		// myAcc.withdraw(1_000_000); // NPE
		Account acc = null; // Local variable, Reference Variable
		acc = new Account("TR1", 100_000);
		System.out.println("Balance: " + acc.getBalance());
		try {
			acc.withdraw(27_500_000_000.);
			acc.withdraw(7_500);
		} catch (InsufficientBalanceEception e) {
			System.out.println(e);
			throw e; // re-throw
		}
		System.out.println("Balance: " + acc.getBalance());
		acc.deposit(32_500);
		System.out.println(acc.toString());
	}
}
