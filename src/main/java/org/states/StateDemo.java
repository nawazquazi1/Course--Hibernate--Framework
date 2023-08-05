package main.java.org.states;


import main.java.org.tut.Certificate;
import main.java.org.tut.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StateDemo {

	
	public static void main(String[] args) {
		
		//Practical of Hibernate Object States:
		//Transient
		//Persistent 
		//Detached 
		//Removed
		System.out.println("Example :");
		
		SessionFactory f=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		
		//Creating student object:
		Student student=new Student();
		student.setId(1414);
		student.setName("Peter");
		student.setCity("ABC");
		student.setCerti(new Certificate("Java Hibernate Course","2 month"));
		//student : Transient
		
		Session s=f.openSession();
		Transaction tx=s.beginTransaction();
		s.save(student);
		//student: Persistent - session,database
		student.setName("John");
		
		tx.commit();
		
		s.close();
		//student : Detached:
		student.setName("Sachin");
		
		System.out.println(student);
		f.close();
	}

}
