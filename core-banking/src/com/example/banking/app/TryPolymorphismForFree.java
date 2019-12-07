package com.example.banking.app;

import java.security.SecureRandom;
import java.util.Random;

import com.example.banking.domain.Account;
import com.example.banking.domain.CheckingAccount;
import com.example.banking.domain.InsufficientBalanceEception;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
@SuppressWarnings("unused")
public class TryPolymorphismForFree {
	private static final Random random = new SecureRandom();

	public static void main(String[] args) throws InsufficientBalanceEception {
		Object o;
		o = 42;
		o = 3.14;
		o = "Jack";
		o = true;
		o = new int[] { 4, 8, 15, 16, 23, 42 };
		o = new Account("TR1", 10_000);
		o = new CheckingAccount("TR2", 20_000, 5_000);

		Account acc;
		if (random.nextBoolean()) {
			acc = new Account("TR1", 10_000);
		} else {
			acc = new CheckingAccount("TR2", 20_000, 5_000);
		}
		System.out.println(acc.getClass().getName());
		acc.withdraw(15_000); // Account ? CheckingAcount
	}

}
