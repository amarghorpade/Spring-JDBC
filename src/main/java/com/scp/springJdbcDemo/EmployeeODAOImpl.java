package com.scp.springJdbcDemo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcTemplate;

public class EmployeeODAOImpl<T> implements EmployeeDAO<Employee> {

	// ********************************Using DataSource****************************************

	/*
	DataSource dataSource;

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public boolean addEmployee(Employee emp) {
		JdbcTemplate jdbcTemplate = newJdbcTemplate(dataSource);
		Object[] array = { emp.getEmpId(), emp.getEmpName(), emp.getSalary() };
		jdbcTemplate.update(
				"insert into EmpTable(empId, empName,empSal) values(?,?,?)",
				array);
		return true;
	}

	public Employee getEmployee(int empId) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		return jdbcTemplate.queryForObject("select  from EmpTable where empId="
				+ empId, new EmpMapper());
	}

	public List<Employee> getAllEmployee() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List list = jdbcTemplate
				.query("select  from empTable", new EmpMapper());
		return list;
	}

	public Employee updateEmployee(Employee emp) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(
				"update Emptable set empname=? , empsal=? where empid=?",
				emp.getEmpName(), emp.getSalary(), emp.getEmpId());
		return getEmployee(emp.getEmpId());
	}

	public boolean deleteEmployee(int empId) {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update("delete from emptable where empid=" + empId);
		return true;
	}

*/	
	
	// ********************************************Using JdbcTemplate********************************

/*	JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public boolean addEmployee(Employee emp) {
		Object[] array = { emp.getEmpId(), emp.getEmpName(), emp.getSalary() };
		jdbcTemplate.update(
				"insert into EmpTable(empId, empName,empSal) values(?,?,?)",
				array);
		return true;
	}

	public Employee getEmployee(int empId) {
		return jdbcTemplate.queryForObject(
				"select * from EmpTable where empId=" + empId, new EmpMapper());
	}

	public List<Employee> getAllEmployee() {
		List list = jdbcTemplate.query("select * from empTable",
				new EmpMapper());
		return list;
	}

	public Employee updateEmployee(Employee emp) {
		jdbcTemplate.update(
				"update Emptable set empname=? , empsal=? where empid=?",
				emp.getEmpName(), emp.getSalary(), emp.getEmpId());
		return getEmployee(emp.getEmpId());
	}

	public boolean deleteEmployee(int empId) {
		jdbcTemplate.update("delete from emptable where empid=" + empId);
		return true;
	}

*/	
	
	// ********************************************Using NamedParameterJdbcTemplate********************************

/*	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public EmployeeODAOImpl(
			NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		super();
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
		return namedParameterJdbcTemplate;
	}

	public void setNamedParameterJdbcTemplate(
			NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	public boolean addEmployee(Employee emp) {

		Map map = new HashMap();
		map.put("empid", emp.getEmpId());
		map.put("empname", emp.getEmpName());
		map.put("empsal", emp.getSalary());
		namedParameterJdbcTemplate.update("insert into empTable "
				+ "(empid, empname, empsal) "
				+ "VALUES (:empid, :empname, :empsal)", map);

		return true;
	}

	public Employee getEmployee(int empId) {

		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("emp_id", empId);
		return namedParameterJdbcTemplate.queryForObject("select * from emptable where empid = :emp_id", map,new EmpMapper());

		 SECOND WAY---- 
		  SqlParameterSource id = new MapSqlParameterSource("emp_id", empId); 
		  Employee emp =namedParameterJdbcTemplate.queryForObject("select * from emptable where empid = :emp_id",id,new EmpMapper());
		   return emp;
		 
	}

	public List<Employee> getAllEmployee() {

		return namedParameterJdbcTemplate.query("select * from emptable",
				new EmpMapper());
	}

	public Employee updateEmployee(Employee emp) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("emp_name", emp.getEmpName());
		map.put("emp_sal", emp.getSalary());
		map.put("emp_id", emp.getEmpId());

		namedParameterJdbcTemplate
				.update("update emptable set empname = :emp_name, empsal = :emp_sal where empid = :emp_id",
						map);
		return getEmployee(emp.getEmpId());
	}

	public boolean deleteEmployee(int empId) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("emp_id", empId);
		namedParameterJdbcTemplate.update(
				"delete from emptable where empid=:emp_id", map);
		return true;
	}

*/	
	
	
	// *********************SimpleJdbcTemplate************************************

	SimpleJdbcTemplate simpleTemplate;

	public EmployeeODAOImpl(SimpleJdbcTemplate simpleTemplate) {
		super();
		this.simpleTemplate = simpleTemplate;
	}

	public SimpleJdbcTemplate getSimpleTemplate() {
		return simpleTemplate;
	}

	public void setSimpleTemplate(SimpleJdbcTemplate simpleTemplate) {
		this.simpleTemplate = simpleTemplate;
	}

	public boolean addEmployee(Employee emp) {

		Object[] array = { emp.getEmpId(), emp.getEmpName(), emp.getSalary() };
		simpleTemplate.update(
				"insert into EmpTable(empId, empName,empSal) values(?,?,?)",
				array);
		return true;
	}

	public Employee getEmployee(int empId) {
		return simpleTemplate.queryForObject(
				"select * from EmpTable where empId=" + empId, new EmpMapper());
	}

	public List<Employee> getAllEmployee() {
		List list = simpleTemplate.query("select * from empTable",
				new EmpMapper());
		return list;
	}

	public Employee updateEmployee(Employee emp) {
		simpleTemplate.update(
				"update Emptable set empname=? , empsal=? where empid=?",
				emp.getEmpName(), emp.getSalary(), emp.getEmpId());
		return getEmployee(emp.getEmpId());
	}

	public boolean deleteEmployee(int empId) {
		simpleTemplate.update("delete from emptable where empid=" + empId);
		return true;
	}

}
