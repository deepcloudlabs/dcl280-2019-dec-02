package com.example.banking.app;

import java.util.function.Consumer;

import com.example.banking.domain.Account;
import com.example.banking.domain.Customer;
import com.example.banking.domain.InsufficientBalanceEception;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public class CustomerApp {

	public static void main(String[] args) {
		Customer jack = new Customer("1", "Jack Bauer");
		Account acc1 = new Account("TR1", 100_000);
		Account acc2 = new Account("TR2", 200_000);
		Account acc3 = new Account("TR3", 300_000);
		jack.addAccount(acc1);
		jack.addAccount(acc2);
		jack.addAccount(acc3);
		System.out.println("Number of accounts: " + jack.getNumberOfAccounts());

		Consumer<Account> withdraw45k = acc -> {
			try {
				acc.withdraw(45_000);
			} catch (InsufficientBalanceEception e) {
				e.printStackTrace();
			}
		};
		Consumer<Account> withdraw5k = acc -> {
			try {
				acc.withdraw(5_000);
			} catch (InsufficientBalanceEception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		};
		jack.getAccount("TR1").ifPresent(withdraw45k.andThen(withdraw5k));
		jack.removeAccount("TR2").ifPresentOrElse(acc -> // Java 9
		System.out.println(acc.getIban() + " is removed"), () -> System.out.println("Cannot find TR2"));
		System.out.println("Number of accounts: " + jack.getNumberOfAccounts());

	}

}
