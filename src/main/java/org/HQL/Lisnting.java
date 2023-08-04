package main.java.org.HQL;

import java.util.List;

import main.java.org.hibernate.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Lisnting {
	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Users.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			// Start transaction
			session.beginTransaction();

			List<Users> users = session.createQuery("from users").getResultList();

			for (Users temp : users) {
				System.out.println(temp);
			}

		} finally {
			session.close();
			factory.close();
		}

	}
}
