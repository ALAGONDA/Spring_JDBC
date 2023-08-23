package com.example.demo.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.Student;

@Repository
public class StudentDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

//	@Autowired
//	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public int insert(Student student) {
		String sql = "insert into Student(phoneno,name,address) values(?,?,?)";

		int update = jdbcTemplate.update(sql, student.getPhoneno(), student.getName(), student.getAddress());

		return update;

	}

	public int modify(Student student) {
		String sql = "update student set address=?,name=? where phoneno=?";
		int update = jdbcTemplate.update(sql, student.getAddress(), student.getName(), student.getPhoneno());
		return update;

	}

	public int deleteByPhoneno(long phoneno) {
		String sql = "delete from student where phoneno=?";

		int update = jdbcTemplate.update(sql, phoneno);
		return update;

	}

	public List<Student> fetchAll() {
		String sql = "select * from student";
		List<Student> query = jdbcTemplate.query(sql, new StudentRepo());

		return query;

	}

	public Student findByPhoneno(long phoneno) {
		String sql = "select * from student where phoneno=?";
		Student queryForObject = jdbcTemplate.queryForObject(sql, new StudentRepo(), phoneno);
		return queryForObject;

	}

	public int[] insertInBatch(List<Student> student) {
		String sql = "insert into Student(phoneno,name,address) values(?,?,?)";
		int[] batchUpdate = jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps, int i) throws SQLException {
				ps.setLong(1, student.get(i).getPhoneno());
				ps.setString(2, student.get(i).getName());
				ps.setString(3, student.get(i).getAddress());

			}

			@Override
			public int getBatchSize() {

				return student.size();
			}
		});
		return batchUpdate;

	}

}
