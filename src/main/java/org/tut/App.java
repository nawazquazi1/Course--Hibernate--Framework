package main.java.org.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

public class App {
	public static void main(String[] args)throws IOException {
		System.out.println("Project started..");

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		//creating student
//		Student st=new Student();
//		st.setId(110);
//		st.setName("Ankit");
//		st.setCity("Delhi");
//		System.out.println(st);

		Session session=factory.openSession();
		Transaction transaction=session.beginTransaction();
//		session.save(st);
//		transaction.commit();



		//creating object of address class
		Address ad=new Address();
		ad.setStreet("street2 ");
		ad.setCity("Kanpur");
		ad.setOpen(false);
		ad.setAddedDate(new Date());
		ad.setX(1234.234);

		// Reading image
		FileInputStream fis=new FileInputStream("src/pic.jpeg");
		byte[] data=new byte[fis.available()];
		fis.read(data);
		ad.setImage(data);


		session.save(ad);
		transaction.commit();

		session.close();
		System.out.println("Done..");
//
		
		
		
		
		
	

	}
}
