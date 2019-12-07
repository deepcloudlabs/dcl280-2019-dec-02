package com.example.banking.domain;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public enum AccountStatus {
	ACTIVE(100), CLOSED(200);
	private int code;

	private AccountStatus(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

}
