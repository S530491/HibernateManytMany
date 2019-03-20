package com.demo.studentmain;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.entity.Course;
import com.demo.entity.Instructor;
import com.demo.entity.InstructorDetail;
import com.demo.entity.Review;
import com.demo.entity.Student;

public class GetCoursesForMaryDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		create session factory
SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).addAnnotatedClass(Student.class).buildSessionFactory();
//create session
Session session=factory.getCurrentSession();
try {

	
//	get instructor from the db
	session.beginTransaction();
	int i=2;
	Student s=session.get(Student.class, i);
	
//	create some courses
	System.out.println("loaded student: "+s);
	System.out.println("Courses: "+s.getCourses());
//	save the student object
//	this will also save the details object too because of the CascadeType.All
	
	session.getTransaction().commit();
}finally {
	session.close();
	factory.close();
}
	}
}
