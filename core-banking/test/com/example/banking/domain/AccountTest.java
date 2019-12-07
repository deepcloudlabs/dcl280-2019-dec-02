package com.example.banking.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AccountTest {
	@Test
	public void createAccount() throws Exception {
		// Setup + Exercise
		Account account = new Account("TR1", -100.);
		// Verify
		assertEquals("TR1", account.getIban());
		assertEquals(0, account.getBalance());
		assertEquals(AccountStatus.ACTIVE, account.getStatus());
		// Verify : equals + hashCode
		assertTrue(account.equals(account));
		Account x = new Account("TR1", -100.);
		Account y = new Account("TR1", -100.);
		Account z = new Account("TR1", -100.);
		Account u = new Account("TR2", -100.);
		assertTrue(x.equals(y));
		assertTrue(y.equals(z));
		assertTrue(x.equals(z));
		assertEquals(x.hashCode(), y.hashCode());
		assertNotEquals(x.hashCode(), u.hashCode());
	}

	@Test
	void toString_shouldContainIbanOnly() {
		// Setup
		Account account = new Account("TR1", 1_000.);
		// Exercise & Verify
		assertTrue(account.toString().toLowerCase().contains("iban="));
		assertFalse(account.toString().toLowerCase().contains("balance="));
	}

	@Test
	@DisplayName("shoud throw IllegalArgumentException if deposit negative amount")
	void deposit_withNegativeAmount_throwsIllegalArgumentException() {
		// Setup
		Account account = new Account("TR1", 1_000.);
		assertEquals("TR1", account.getIban());
		assertEquals(1_000, account.getBalance());
		assertEquals(AccountStatus.ACTIVE, account.getStatus());
		// Exercise + Verify
		assertThrows(IllegalArgumentException.class, () -> account.deposit(-10.));
		assertEquals(1_000, account.getBalance());
	}

	@Test
	void deposit_withZeroAmount_throwsIllegalArgumentException() {
		// Setup
		Account account = new Account("TR1", 1_000.);
		assertEquals("TR1", account.getIban());
		assertEquals(1_000, account.getBalance());
		assertEquals(AccountStatus.ACTIVE, account.getStatus());
		// Exercise
		assertThrows(IllegalArgumentException.class, () -> account.deposit(0.));
		// Verify
		assertEquals(1_000, account.getBalance());
	}

	@Test
	void deposit_withPositiveAmount() {
		// Setup
		Account account = new Account("TR1", 1_000.);
		assertEquals("TR1", account.getIban());
		assertEquals(1_000, account.getBalance());
		assertEquals(AccountStatus.ACTIVE, account.getStatus());
		// Exercise
		account.deposit(10.);
		assertEquals(1_010, account.getBalance());
	}

	@Test
	@DisplayName("shoud throw IllegalArgumentException if withdraw negative amount")
	void withdraw_withNegativeAmount_throwsIllegalArgumentException() {
		// Setup
		Account account = new Account("TR1", 1_000.);
		assertEquals("TR1", account.getIban());
		assertEquals(1_000, account.getBalance());
		assertEquals(AccountStatus.ACTIVE, account.getStatus());
		// Exercise
		assertThrows(IllegalArgumentException.class, () -> account.withdraw(-10.));
		assertEquals(1_000, account.getBalance());
	}

	@Test
	void withdraw_withZeroAmount_throwsIllegalArgumentException() {
		// Setup
		Account account = new Account("TR1", 1_000.);
		assertEquals("TR1", account.getIban());
		assertEquals(1_000, account.getBalance());
		// Exercise
		assertThrows(IllegalArgumentException.class, () -> account.withdraw(0.));
		// Verify
		assertEquals(1_000, account.getBalance());
	}

	@Test
	void withdraw_overBalance_throwsInsufficientBalanceEception() {
		// Setup
		Account account = new Account("TR1", 1_000.);
		assertEquals("TR1", account.getIban());
		assertEquals(1_000, account.getBalance());
		// Exercise
		assertThrows(InsufficientBalanceEception.class, () -> account.withdraw(1001.));
		assertEquals(1_000, account.getBalance());
	}

	@Test
	void withdraw_allBalance_success() throws Throwable {
		// Setup
		Account account = new Account("TR1", 1_000.);
		assertEquals("TR1", account.getIban());
		assertEquals(1_000, account.getBalance());
		// Exercise
		account.withdraw(1000.);
		assertEquals(0., account.getBalance());
	}

}
