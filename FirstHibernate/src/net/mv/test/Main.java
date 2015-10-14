package net.mv.test;

import net.mv.hibernate.Course;
import net.mv.hibernate.HibernateUtil;
import net.mv.hibernate.Student;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Main {

	
	public static void main(String[] args) {
		
		
		//Open Session
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		
		Course math = new Course(3, "Linear Algebra");
		Course cs   = new Course(4, "Advanced Java");
		
		Student jason = new Student(3, "Jason");
		Student kevin = new Student(4, "Kevin");
	
		jason.getCourses().add(math);
		jason.getCourses().add(cs);
		kevin.getCourses().add(math);
		
		System.out.println(jason);
		System.out.println(kevin);
		
		
		
		session.save(jason);
		session.save(kevin);
		
		
		
		
		/*
		 * Fetching (of associations)
		 * 
		 * Lazy Fetching and Eager Fetching
		 * 
		 * Lazy Fetching - DON'T retrieve associations UNTIL requested
		 * 
		 * Eager Fetching - Automatically retrieve associations
		 *
		 * 
		 * 
		 * 
		 * System.out.println("Get department name of Austin");		
		Employee austin = (Employee) session.get(Employee.class, 3);
		
		System.out.println(austin.getName());
				
		System.out.println(austin.getDepartment().getName());
		
		
		System.out.println("Get all Employees in Department Finance");
		Department finance = (Department) session.get(Department.class, 1);
		
		System.out.println(finance.getName());
		
		System.out.println(finance.getEmployees());
		 */
		
		
//		Department finance = new Department(1, "Finance");
//		Department sales = new Department(2, "Sales");
//		
//		Employee john = new Employee(1, "John", finance);
//		Employee amy = new Employee(2, "Amy", finance);
//		
//		Employee austin = new Employee(3, "Austin", sales);
//		Employee katie = new Employee(4, "Katie", sales);
//		Employee courtney = new Employee(5, "Courtney", sales);
//		
//		session.save(finance);
//		session.save(sales);
//		
//		session.save(john);
//		session.save(amy);
//		
//		session.save(austin);
//		session.save(katie);
//		session.save(courtney);
		
		
		
		
		
		tx.commit();
		session.close();
		
	}
}
