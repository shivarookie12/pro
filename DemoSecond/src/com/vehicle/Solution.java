package com.vehicle;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Solution {

	public static void main(String[] args) {
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		Session session = sf.openSession();
		Vehicle vehicle = new Vehicle();
		vehicle.setName("car");
		TwoWheeler two = new TwoWheeler();
		two.setName("Bike");
		two.setSteeringHandle("Bike Steering");
		FourWheeler four = new FourWheeler();
		four.setName("AudiR8");
		four.setSteeringWheel("AudiR8 Steering");
		session.beginTransaction();
		session.save(vehicle);
		session.save(two);
		session.save(four);
		session.getTransaction().commit();
		session.close();
		sf.close();
	}

}
