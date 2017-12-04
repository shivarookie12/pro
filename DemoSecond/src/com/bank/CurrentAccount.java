package com.bank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "CURRENTACC")
public class CurrentAccount extends BankAccount {
	@Column(name = "Min_Amount")
	private static double minimumAmountCanTransfer = 500000;
	@Column(name = "Min_Transaction")
	private static int minimumNumberOfTransactions = 7;
	@Transient
	private double amountTransfered;
	@Column(name = "Number_Of_Trans")
	private int numberOfTransactionsHeld;

	public CurrentAccount() {
		super();
	}

	public CurrentAccount(long accountNumber, String accountHolder, String address, long phoneNumber, String emailId,
			double balance, double amountTransfered, int numberOfTransactionsHeld) {
		super(accountNumber, accountHolder, address, phoneNumber, emailId, balance);
		this.amountTransfered = amountTransfered;
		this.numberOfTransactionsHeld = numberOfTransactionsHeld;
	}

	public static double getMinimumAmountCanTransfer() {
		return minimumAmountCanTransfer;
	}

	public static void setMinimumAmountCanTransfer(double minimumAmountCanTransfer) {
		CurrentAccount.minimumAmountCanTransfer = minimumAmountCanTransfer;
	}

	public static int getMinimumNumberOfTransactions() {
		return minimumNumberOfTransactions;
	}

	public static void setMinimumNumberOfTransactions(int minimumNumberOfTransactions) {
		CurrentAccount.minimumNumberOfTransactions = minimumNumberOfTransactions;
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
		if (numberOfTransactionsHeld >= minimumNumberOfTransactions && amountTransfered <= minimumAmountCanTransfer) {
			balance -= balance * 0.05;
			return super.withdraw(amount);
		} else if (numberOfTransactionsHeld <= minimumNumberOfTransactions
				&& amountTransfered <= minimumAmountCanTransfer) {
			return super.withdraw(amount);
		} else if (amountTransfered > minimumAmountCanTransfer) {
			System.out.println("Tansfer limit exceeded");
		}
		return false;
	}

	@Override
	public boolean deposit(double amount) {
		if (numberOfTransactionsHeld >= minimumNumberOfTransactions && amountTransfered <= minimumAmountCanTransfer) {
			balance -= balance * 0.05;
			return super.deposit(amount);
		} else if (numberOfTransactionsHeld <= minimumNumberOfTransactions
				&& amountTransfered <= minimumAmountCanTransfer) {
			return super.deposit(amount);
		} else if (amountTransfered > minimumAmountCanTransfer) {
			System.out.println("Tansfer limit exceeded");
		}
		return false;
	}

}