package org.main.emp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Solution {
	public static void main(String[] args) throws IOException {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		session.beginTransaction();
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter Name : ");
		String name = bf.readLine();
		System.out.print("Enter Email : ");
		String email = bf.readLine();
		System.out.print("Enter Phone : ");
		long phone = Long.valueOf(bf.readLine());
		Employee employee = new Employee(name, email, phone);
		System.out.println("Id :" + " " + employee.getId());
		System.out.println("Name :" + " " + employee.getName());
		System.out.println("Email :" + " " + employee.getEmail());
		System.out.println("Phone :" + " " + employee.getPhone());
		session.save(employee);
		session.getTransaction().commit();
		session.close();
	}

}
