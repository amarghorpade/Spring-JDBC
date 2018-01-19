package com.scp.springJdbcDemo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class EmployeeMain {

	public static void main(String[] args) {
		ApplicationContext contxt = new FileSystemXmlApplicationContext("D:\\workspace\\springJdbcDemo\\src\\main\\java\\spring-servlet.xml");
		EmployeeODAOImpl empDAO = (EmployeeODAOImpl) contxt.getBean("dao");
		
		Employee emp = new Employee(105, "Anshu Rane", 7777);
		empDAO.addEmployee(emp);
		//System.out.println(empDAO.getEmployee(102));
		//empDAO.deleteEmployee(105);	
		//empDAO.updateEmployee(emp);
		System.out.println(empDAO.getAllEmployee());
		
	}
}
