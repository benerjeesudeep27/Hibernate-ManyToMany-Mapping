package com.manytomany.mapping.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import com.manytomany.mapping.entity.Employee;
import com.manytomany.mapping.entity.Project;

public class TestApp {
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		Properties props = new Properties();
		props.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
		props.put(Environment.URL, "jdbc:mysql://localhost:3306/Many_To_Many");
		props.put(Environment.USER, "root");
		props.put(Environment.PASS, "Shiva@12345");
		props.put(Environment.HBM2DDL_AUTO, "create");
		props.put(Environment.SHOW_SQL, "true");
		props.put(Environment.FORMAT_SQL, "true");
		cfg.setProperties(props);
		cfg.addAnnotatedClass(Employee.class);
		cfg.addAnnotatedClass(Project.class);
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
		StandardServiceRegistry registry = builder.applySettings(cfg.getProperties()).build();
		SessionFactory factory = cfg.buildSessionFactory(registry);
		Session session = factory.openSession();
		Employee emp = new Employee();
		emp.setEmpId(101);
		emp.setEmpName("Sudeep Banerjee");
		Employee emp1 = new Employee();
		emp1.setEmpId(102);
		emp1.setEmpName("Kavita Sharma");
		Employee emp2 = new Employee();
		emp2.setEmpId(103);
		emp2.setEmpName("Summit Dey");
		Project pro = new Project();
		pro.setProId(555);
		pro.setProName("Gaming");
		Project pro1 = new Project();
		pro1.setProId(666);
		pro1.setProName("Animation");
		List<Employee> empList1 = new ArrayList<Employee>();
		empList1.add(emp);
		empList1.add(emp1);
		List<Employee> empList2 = new ArrayList<Employee>();
		empList2.add(emp1);
		empList2.add(emp2);
		List<Employee> empList3 = new ArrayList<Employee>();
		empList3.add(emp1);
		empList3.add(emp2);
		empList3.add(emp);

		List<Project> proList1 = new ArrayList<Project>();
		proList1.add(pro);
		List<Project> proList2 = new ArrayList<Project>();
		proList2.add(pro1);
		proList2.add(pro);

		emp.setProjects(proList2);
		emp1.setProjects(proList1);
		emp2.setProjects(proList2);

//		pro.setEmployees(empList3);
//		pro1.setEmployees(empList1);

		session.save(emp);
		session.save(emp1);
		session.save(emp2);
		Transaction tx = session.beginTransaction();
		tx.commit();
		System.out.println("Data Inserted");
	}
}
