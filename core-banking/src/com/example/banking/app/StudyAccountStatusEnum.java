package com.example.banking.app;

import com.example.banking.domain.AccountStatus;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public class StudyAccountStatusEnum {

	public static void main(String[] args) {
		for (AccountStatus status : AccountStatus.values())
			System.out.println(status.ordinal() + ": " + status.name());
	}

}
