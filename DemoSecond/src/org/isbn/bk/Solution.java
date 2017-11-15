package org.isbn.bk;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Solution {
	public static void main(String[] args) throws IOException {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter Name");
		String name=bf.readLine();
		System.out.print("Enter PublisherName : ");
		String publisher=bf.readLine();
		System.out.print("Enter AuthorName : ");
		String author=bf.readLine();
		System.out.print("Enter Price : ");
		double price=Double.valueOf(bf.readLine());
		System.out.print("Enter PublishedDate : ");
		Date published = new Date(bf.readLine());
		System.out.print("Enter ISBN-Number : ");
		String isbnNumber=bf.readLine();
		Book book = new Book(name,publisher, author, price, published, isbnNumber);
		session.save(book);
		session.getTransaction().commit();
		session.close();
	}
}
