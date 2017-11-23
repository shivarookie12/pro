package org.grocery.stock;

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
		/*
		 * Item item = session.get(Item.class, 1);
		 * System.out.println(item.getId()); System.out.println(item.getName());
		 * System.out.println(item.getPrice());
		 * System.out.println(item.getQuantity()); session.beginTransaction();
		 * item.setName("apple"); session.update(item);
		 * session.getTransaction().commit(); System.out.println("updated");
		 * session.beginTransaction(); session.delete(item);
		 * session.getTransaction().commit(); session.close();
		 */
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			System.out.println("ENTER CHOICE 1-INSERT 2-UPDATE 3-DELETE 4-DISPLAY 5-TOTAL_NUMBER_OF_ITEMS 6-SELECT ");
			int ch = Integer.valueOf(bf.readLine());
			Item item;
			switch (ch) {
			case 1: {
				session.beginTransaction();
				System.out.print("Enter ItemName : ");
				String name = bf.readLine();
				System.out.print("Enter Quantity : ");
				int quantity = Integer.valueOf(bf.readLine());
				System.out.print("Enter Price : ");
				double price = Double.valueOf(bf.readLine());
				 item = new Item(name, quantity, price);
				session.save(item);
				session.getTransaction().commit();
				System.out.println("Inserted");				
				break;
			}
			case 2: {
				System.out.print("Enter id ");
				int id = Integer.valueOf(bf.readLine());
				 item = session.get(Item.class, id);
				/*
				 * System.out.println(item.getId());
				 * System.out.println(item.getName());
				 * System.out.println(item.getPrice());
				 * System.out.println(item.getQuantity());
				 */
				session.beginTransaction();
				item.setName("apple");
				session.update(item);
				session.getTransaction().commit();
				System.out.println("updated");
				break;
			}
			case 3: {
				System.out.print("Enter id ");
				int id = Integer.valueOf(bf.readLine());
				 item = session.get(Item.class, id);
				session.beginTransaction();
				session.delete(item);
				session.getTransaction().commit();
				break;
			}
			case 4: {

				System.out.print("Enter id ");
				int id = Integer.valueOf(bf.readLine());
				 item = session.get(Item.class, id);
				System.out.println(item.getId());
				System.out.println(item.getName());
				System.out.println(item.getPrice());
				System.out.println(item.getQuantity());
				break;
			}
			case 5: {
			int id=1,c=0;
			while(true){
				 
				 if(id>=1){
					 item = session.get(Item.class, id);
					 if(item==null){
						 break;
					 }
					 else{
						 c++;
						 id++;
					 }
					 
				 }
			}
			System.out.println("totalNumberOfItems"+" "+c);
				//System.out.println("totalNumberOfItems  " + Item.getTotalNumberOfItems());
				break;
			}
			case 6: {

				System.out.print("Enter id ");
				int id = Integer.valueOf(bf.readLine());
				 item = session.get(Item.class, id);
				
				if (item==(null)) {
					System.out.println("Item doesnot exsist");
				} else {
					System.out.println("Item  exsist");
				}
				break;
			}
			default:
				System.exit(0);
			}
		}

	}

}