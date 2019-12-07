package com.example.banking.app;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import com.example.banking.domain.Bank;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public class ReadBankFromFile {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		File file = new File("c:/temp", "mybank.dat");
		try (FileInputStream fis = new FileInputStream(file); ObjectInputStream ois = new ObjectInputStream(fis);) {
			Bank bank = (Bank) ois.readObject();
			bank.getCustomer("1").ifPresentOrElse(System.out::println,
					() -> System.out.println("Cannot find the customer 1"));
			bank.getCustomer("2").ifPresentOrElse(System.out::println,
					() -> System.out.println("Cannot find the customer 1"));
		}
	}

}
