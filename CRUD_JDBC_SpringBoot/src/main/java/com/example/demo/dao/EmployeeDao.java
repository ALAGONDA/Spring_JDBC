package com.example.demo.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.Employee;

@Repository
public class EmployeeDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public int insert(Employee employee) {
		String sql = "insert into employee(id,deptno,department) values(?,?,?)";
		int update = jdbcTemplate.update(sql, employee.getId(), employee.getDeptno(), employee.getDepartment());
		return update;

	}

	public int modify(Employee employee) {
		String sql = "update student set deptno=?,department=? where id=?";
		int update = jdbcTemplate.update(sql, employee.getId(), employee.getDeptno(), employee.getDepartment());
		return update;

	}

	public int dropRow(int id) {
		String sql = "delete from employee where id=?";
		int update = jdbcTemplate.update(sql, id);
		return update;

	}

	public List<Employee> fetch() {
		String sql = "select * from employee";
		List<Employee> query = jdbcTemplate.query(sql, new EmployeeRepo());
		return query;

	}

	public Employee fetchById(int id) {
		String sql = "select * from employee where id=?";
		Employee queryForObject = jdbcTemplate.queryForObject(sql, new EmployeeRepo(), id);
		return queryForObject;

	}

	public int[] insertInList(List<Employee> employees) {
		String sql = "insert into Employee(id,deptno,department) values(?,?,?)";

		int[] batchUpdate = jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				ps.setInt(1, employees.get(i).getId());
				ps.setInt(2, employees.get(i).getDeptno());
				ps.setString(3, employees.get(i).getDepartment());

			}

			@Override
			public int getBatchSize() {
				// TODO Auto-generated method stub
				return employees.size();
			}

		});
		return batchUpdate;

	}

}
