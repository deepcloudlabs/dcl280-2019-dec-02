package com.example.banking.app;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import com.example.banking.domain.Account;
import com.example.banking.domain.Bank;
import com.example.banking.domain.CheckingAccount;
import com.example.banking.domain.Customer;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public class WriteBankToFile {

	public static void main(String[] args) throws IOException {
		Bank bank = new Bank(1, "mybank");
		Customer jack = bank.createCustomer("1", "Jack Bauer");
		jack.addAccount(new Account("TR1", 100_000));
		jack.addAccount(new CheckingAccount("TR2", 200_000, 5000));
		Customer kate = bank.createCustomer("2", "Kate Austen");
		kate.addAccount(new Account("TR3", 300_000));
		kate.addAccount(new CheckingAccount("TR4", 400_000, 25000));
		File file = new File("c:/temp", "mybank.dat");
		try (FileOutputStream fos = new FileOutputStream(file); ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			oos.writeObject(bank);
		}
	}

}
