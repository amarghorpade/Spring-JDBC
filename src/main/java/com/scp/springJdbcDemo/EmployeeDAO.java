package com.scp.springJdbcDemo;

import java.util.List;


public interface EmployeeDAO<T>
{
	public boolean addEmployee(T t);
	public T getEmployee(int empId);
	public List<T> getAllEmployee();
	public T updateEmployee(T t);
	public boolean deleteEmployee(int empId);
}
