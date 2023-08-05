package main.java.org.pegination;


import main.java.org.tut.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class HQLPegination {
	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session s = factory.openSession();

		Query query = s.createQuery("from Student");

		// implementing pegination using hibernate

		query.setFirstResult(10);

		query.setMaxResults(7);

		List<Student> list = query.list();

		for (Student st : list) {
			System.out.println(st.getId()+" : "+st.getName() + " : " + st.getCity());
		}

		s.close();

		factory.close();

	}

}
