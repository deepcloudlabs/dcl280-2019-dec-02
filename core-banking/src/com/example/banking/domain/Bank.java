package com.example.banking.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
@SuppressWarnings("serial")
public final class Bank implements Serializable {
	private final int id;
	private String name;
	private List<Customer> customers;

	public Bank(final int id, String name) {
		this.id = id;
		this.name = name;
		customers = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public Customer createCustomer(String identity, String fullname) {
		Customer customer = new Customer(identity, fullname);
		customers.add(customer);
		return customer;
	}

	public Optional<Customer> getCustomer(String identityNo) {
		for (Customer cust : customers)
			if (cust.getIdentityNo().equals(identityNo))
				return Optional.of(cust);
		return Optional.empty();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Bank other = (Bank) obj;
		if (id != other.id)
			return false;
		return true;
	}

}
