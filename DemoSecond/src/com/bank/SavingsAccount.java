package com.bank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "SAVINGSACC")
public class SavingsAccount extends BankAccount {
	@Column(name = "Max_Amount")
	private static double maximumAmountCanTransfer = 100000;
	@Column(name = "Max_Transaction")
	private static int maximumNumberOfTransactions = 5;
	@Transient
	private double amountTransfered;
	@Column(name = "Number_Of_Trans")
	private int numberOfTransactionsHeld;

	public SavingsAccount() {
		super();
	}

	public SavingsAccount(long accountNumber, String accountHolder, String address, long phoneNumber, String emailId,
			double balance, double amountTransfered, int numberOfTransactionsHeld) {
		super(accountNumber, accountHolder, address, phoneNumber, emailId, balance);
		this.amountTransfered = amountTransfered;
		this.numberOfTransactionsHeld = numberOfTransactionsHeld;
	}

	public static double getMaximumAmountCanTransfer() {
		return maximumAmountCanTransfer;
	}

	public static void setMaximumAmountCanTransfer(double maximumAmountCanTransfer) {
		SavingsAccount.maximumAmountCanTransfer = maximumAmountCanTransfer;
	}

	public static int getMaximumNumberOfTransactions() {
		return maximumNumberOfTransactions;
	}

	public static void setMaximumNumberOfTransactions(int maximumNumberOfTransactions) {
		SavingsAccount.maximumNumberOfTransactions = maximumNumberOfTransactions;
	}

	public double getAmountTransfered() {
		return amountTransfered;
	}

	public void setAmountTransfered(double amountTransfered) {
		this.amountTransfered = amountTransfered;
	}

	public int getNumberOfTransactionsHeld() {
		return numberOfTransactionsHeld;
	}

	public void setNumberOfTransactionsHeld(int numberOfTransactionsHeld) {
		this.numberOfTransactionsHeld = numberOfTransactionsHeld;
	}

	@Override
	public boolean withdraw(double amount) {
		if (numberOfTransactionsHeld <= maximumNumberOfTransactions && amountTransfered <= maximumAmountCanTransfer) {
			balance -= balance * 0.05;
			return super.withdraw(amount);
		} else if (numberOfTransactionsHeld > maximumNumberOfTransactions
				&& amountTransfered <= maximumAmountCanTransfer) {
			return super.withdraw(amount);
		} else if (amountTransfered > maximumAmountCanTransfer) {
			System.out.println("Tansfer limit exceeded");
		}
		return false;
	}

	@Override
	public boolean deposit(double amount) {
		if (numberOfTransactionsHeld <= maximumNumberOfTransactions && amountTransfered <= maximumAmountCanTransfer) {
			balance -= balance * 0.05;
			return super.deposit(amount);
		} else if (numberOfTransactionsHeld > maximumNumberOfTransactions
				&& amountTransfered <= maximumAmountCanTransfer) {
			return super.deposit(amount);
		} else if (amountTransfered > maximumAmountCanTransfer) {
			System.out.println("Tansfer limit exceeded");
		}
		return false;
	}

}