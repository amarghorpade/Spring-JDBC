/**
 * 
 */
package com.scp.springJdbcDemo;

/**
 * @author AmarGhorpde
 *
 */
public class Employee 
{
	private int EmpId;
	private String EmpName;
	private int salary;
	public int getEmpId() {
		return EmpId;
	}
	public void setEmpId(int empId) {
		EmpId = empId;
	}
	public String getEmpName() {
		return EmpName;
	}
	public void setEmpName(String empName) {
		EmpName = empName;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	public Employee(int empId, String empName, int salary) {
		super();
		EmpId = empId;
		EmpName = empName;
		this.salary = salary;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "\n Employee [EmpId=" + EmpId + ", EmpName=" + EmpName
				+ ", salary=" + salary + "]";
	}
	
	
}
