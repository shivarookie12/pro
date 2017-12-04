package com.bank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "BANKACC")
public class BankAccount {
	@Id
	@Column(name = "Account_Number")
	private long accountNumber;
	@Column(name = "Account_Holder")
	private String accountHolder;
	@Column(name = "Address")
	private String address;
	@Column(name = "Phone_Number")
	private long phoneNumber;
	@Column(name = "Email_ID")
	private String emailId;
	@Column(name = "Balance")
	protected double balance;

	public BankAccount() {
		super();
	}

	public BankAccount(long accountNumber, String accountHolder, String address, long phoneNumber, String emailId,
			double balance) {
		super();
		this.accountNumber = accountNumber;
		this.accountHolder = accountHolder;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.emailId = emailId;
		this.balance = balance;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountHolder() {
		return accountHolder;
	}

	public void setAccountHolder(String accountHolder) {
		this.accountHolder = accountHolder;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public boolean withdraw(double amount) {
		if (balance > amount) {
			balance -= amount;
			System.out.println("Balance:" + balance);
			return true;
		} else {
			System.out.println("Transaction failed");
			return false;
		}
	}

	public boolean deposit(double amount) {
		balance += amount;
		System.out.println("Balance:" + balance);
		return true;
	}

}