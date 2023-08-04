package main.java.org.HQL;

import java.util.List;

import main.java.org.hibernate.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class WhereClause {
	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Users.class)
				.buildSessionFactory();

		try (factory; Session session = factory.getCurrentSession()) {
			// Start transaction
			session.beginTransaction();

			List users = session.createQuery("from users where firstName = 'akib'OR lastName like '%a%w%'")
					.getResultList();

			for (Object temp : users) {
				System.out.println(temp);
			}

		}

	}
}
