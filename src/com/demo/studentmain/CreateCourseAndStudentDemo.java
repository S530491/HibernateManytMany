package com.demo.studentmain;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.demo.entity.Course;
import com.demo.entity.Instructor;
import com.demo.entity.InstructorDetail;
import com.demo.entity.Review;
import com.demo.entity.Student;

public class CreateCourseAndStudentDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		create session factory
SessionFactory factory=new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class).addAnnotatedClass(InstructorDetail.class).addAnnotatedClass(Course.class).addAnnotatedClass(Review.class).addAnnotatedClass(Student.class).buildSessionFactory();
//create session
Session session=factory.getCurrentSession();
try {

	
//	get instructor from the db
	session.beginTransaction();
	
	
//	create some courses
	Course t1=new Course("pacman - holhol");
	session.save(t1);
	System.out.println("Saved the Course"+t1);
	Student t=new Student("john","do","john@gmail.com");
	Student t2=new Student("john2","do2","john2@gmail.com");
	
	t1.addStudent(t);
	t1.addStudent(t2);
	System.out.println("saving th students");
	session.save(t);
	session.save(t2);
	System.out.println("saved students: "+t1.getStudents());
//	save the student object
//	this will also save the details object too because of the CascadeType.All
	
	session.getTransaction().commit();
}finally {
	session.close();
	factory.close();
}
	}
}
