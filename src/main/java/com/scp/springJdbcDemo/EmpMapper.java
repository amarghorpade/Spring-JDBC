package com.scp.springJdbcDemo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class EmpMapper implements RowMapper<Employee> {

	public Employee mapRow(ResultSet rs, int i) throws SQLException {
		
		Employee e = new Employee(rs.getInt("empid"),rs.getString("empname"),rs.getInt("empsal"));
		System.out.println("******************** "+i);
		return e;
	}
	


}
