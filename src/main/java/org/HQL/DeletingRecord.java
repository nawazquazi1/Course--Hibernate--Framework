package org.HQL;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hiibernate.Users;

public class DeletingRecord {
	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Users.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();
			session.createQuery("delete from users where userid =5").executeUpdate();
			session.getTransaction().commit();

		} finally {
			session.close();
			factory.close();
		}

	}
}
