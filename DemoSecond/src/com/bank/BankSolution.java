package com.bank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class BankSolution {
	public static void main(String args[]) throws IOException {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		String accountHolder, address, emailId;
		double balance, amountTransfered;
		int choice, choice1, numberOfTransactionsHeld;
		long accountNumber, phoneNumber;
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter 1.New Entry   2.Withdraw   3.Deposit");
		choice = Integer.valueOf(bf.readLine());
		switch (choice) {
		case 1: {
			System.out.print("Enter 1.Current Account    2.Savings Account");
			choice1 = Integer.valueOf(bf.readLine());
			amountTransfered = 0;
			System.out.print("Enter Account Number : ");
			accountNumber = Long.valueOf(bf.readLine());
			System.out.print("Enter AccountHolder : ");
			accountHolder = bf.readLine();
			System.out.print("Enter Address : ");
			address = bf.readLine();
			System.out.print("Enter PhoneNumber : ");
			phoneNumber = Long.valueOf(bf.readLine());
			System.out.print("Enter EmailId : ");
			emailId = bf.readLine();
			System.out.print("Enter balance amount : ");
			balance = Double.valueOf(bf.readLine());
			System.out.print("Enter numberOfTransactionsHeld:");
			numberOfTransactionsHeld = Integer.valueOf(bf.readLine());
			if (choice1 == 1) {
				CurrentAccount ca = new CurrentAccount(accountNumber, accountHolder, address, phoneNumber, emailId,
						balance, amountTransfered, numberOfTransactionsHeld);
				session.save(ca);
				session.getTransaction().commit();
			}
			if (choice1 == 2) {
				SavingsAccount sa = new SavingsAccount(accountNumber, accountHolder, address, phoneNumber, emailId,
						balance, amountTransfered, numberOfTransactionsHeld);
				session.save(sa);
				session.getTransaction().commit();
			}
			break;
		}
		case 2: {
			System.out.println("1.Current Account    2.Savings Account");
			System.out.print("\nSelect account type:");
			choice1 = Integer.valueOf(bf.readLine());
			switch (choice1) {
			case 1:
				System.out.print("\nEnter account number:");
				accountNumber = Long.valueOf(bf.readLine());
				System.out.print("\nEnter amountTransfered:");
				amountTransfered = Double.valueOf(bf.readLine());
				CurrentAccount ca = new CurrentAccount();
				ca = session.get(CurrentAccount.class, accountNumber);
				balance = ca.getBalance();
				numberOfTransactionsHeld = ca.getNumberOfTransactionsHeld();
				ca.withdraw(amountTransfered);
				numberOfTransactionsHeld++;
				ca.setNumberOfTransactionsHeld(numberOfTransactionsHeld);
				session.save(ca);
				session.getTransaction().commit();
				break;
			case 2:
				System.out.print("\nEnter account number:");
				accountNumber = Long.valueOf(bf.readLine());
				System.out.print("\nEnter amountTransfered:");
				amountTransfered = Double.valueOf(bf.readLine());
				System.out.print("\nEnter numberOfTransactionsHeld:");
				numberOfTransactionsHeld = Integer.valueOf(bf.readLine());
				SavingsAccount sa = new SavingsAccount();
				sa = session.get(SavingsAccount.class, accountNumber);
				balance = sa.getBalance();
				numberOfTransactionsHeld = sa.getNumberOfTransactionsHeld();
				sa.withdraw(amountTransfered);
				numberOfTransactionsHeld++;
				sa.setNumberOfTransactionsHeld(numberOfTransactionsHeld);
				session.save(sa);
				session.getTransaction().commit();
				break;
			default:
				break;
			}
			break;
		}
		case 3:
			System.out.println("1.Current Account    2.Savings Account");
			System.out.print("\nSelect account type:");
			choice1 = Integer.valueOf(bf.readLine());
			switch (choice1) {
			case 1:
				System.out.print("\nEnter account number:");
				accountNumber = Long.valueOf(bf.readLine());
				System.out.print("\nEnter amountTransfered:");
				amountTransfered = Double.valueOf(bf.readLine());
				CurrentAccount ca = new CurrentAccount();
				ca = session.get(CurrentAccount.class, accountNumber);
				balance = ca.getBalance();
				numberOfTransactionsHeld = ca.getNumberOfTransactionsHeld();
				ca.deposit(amountTransfered);
				numberOfTransactionsHeld++;
				ca.setNumberOfTransactionsHeld(numberOfTransactionsHeld);
				session.save(ca);
				session.getTransaction().commit();
				break;
			case 2:
				System.out.print("\nEnter account number:");
				accountNumber = Long.valueOf(bf.readLine());
				System.out.print("\nEnter amountTransfered:");
				amountTransfered = Double.valueOf(bf.readLine());
				System.out.print("\nEnter numberOfTransactionsHeld:");
				numberOfTransactionsHeld = Integer.valueOf(bf.readLine());
				SavingsAccount sa = new SavingsAccount();
				sa = session.get(SavingsAccount.class, accountNumber);
				balance = sa.getBalance();
				numberOfTransactionsHeld = sa.getNumberOfTransactionsHeld();
				sa.deposit(amountTransfered);
				numberOfTransactionsHeld++;
				sa.setNumberOfTransactionsHeld(numberOfTransactionsHeld);
				session.save(sa);
				session.getTransaction().commit();
				break;
				default:
					break;
			}
			break;
		}
		session.close();
	}
}
