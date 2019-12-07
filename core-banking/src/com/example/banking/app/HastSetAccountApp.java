package com.example.banking.app;

import java.util.HashSet;
import java.util.Set;

import com.example.banking.domain.Account;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public class HastSetAccountApp {

	public static void main(String[] args) {
		Set<Account> accounts = new HashSet<>();
		accounts.add(new Account("TR1", 100_000));
		accounts.add(new Account("TR1", 100_000));
		accounts.add(new Account("TR1", 100_000));
		accounts.add(new Account("TR1", 100_000));
		accounts.add(new Account("TR1", 100_000));
		accounts.add(new Account("TR1", 100_000));
		accounts.add(new Account("TR1", 100_000));
		accounts.add(new Account("TR1", 100_000));
		accounts.add(new Account("TR1", 100_000));
		accounts.add(new Account("TR1", 100_000));
		accounts.add(new Account("TR1", 100_000));
		accounts.add(new Account("TR1", 100_000));
		accounts.add(new Account("TR1", 100_000));
		accounts.add(new Account("TR1", 100_000));
		accounts.add(new Account("TR1", 100_000));
		accounts.add(new Account("TR1", 100_000));
		accounts.add(new Account("TR1", 100_000));
		accounts.add(new Account("TR1", 100_000));
		System.out.println(accounts.size());
		System.out.println(accounts.contains(new Account("TR1", 100_000)));
	}

}
