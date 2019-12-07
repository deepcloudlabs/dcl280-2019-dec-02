package com.example.banking.domain;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
@SuppressWarnings("serial")
public class InsufficientBalanceEception extends Exception {

	private final double deficit;

	public InsufficientBalanceEception(String message, double deficit) {
		super(message);
		this.deficit = deficit;
	}

	public double getDeficit() {
		return deficit;
	}

	@Override
	public String toString() {
		return "InsufficientBalanceEception [deficit=" + deficit + ", getMessage()=" + getMessage() + "]";
	}

}
