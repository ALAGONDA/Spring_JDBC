package com.example.demo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.example.demo.dto.Employee;

public class EmployeeRepo implements RowMapper<Employee>{

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		return new Employee(rs.getInt("id"),rs.getInt("deptno"),rs.getString("department"));
	}

}
