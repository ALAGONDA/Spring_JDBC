package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.demo.dao.StudentDao;
import com.example.demo.dto.Student;
import com.example.demo.response.StudentResponse;

@Service
public class StudentService {

	@Autowired
	private StudentDao studentDao;

	public StudentResponse<?> insert(Student student) {
		int insert = studentDao.insert(student);

		StudentResponse<Integer> response = new StudentResponse<>();

		response.setData(insert);
		response.setMsg("Data inserted");
		response.setHttpStatus(HttpStatus.OK);

		return response;
	}

	public StudentResponse<?> modify(Student student) {
		int modify = studentDao.modify(student);

		StudentResponse<Integer> response = new StudentResponse<>();

		response.setData(modify);
		response.setMsg("Data modified");
		response.setHttpStatus(HttpStatus.OK);

		return response;

	}

	public StudentResponse<?> deleteByPhoneno(long phoneno) {
		int deleteByPhoneno = studentDao.deleteByPhoneno(phoneno);

		StudentResponse<Integer> response = new StudentResponse<>();
		response.setData(deleteByPhoneno);
		response.setMsg("row deleted based on phoneno");
		response.setHttpStatus(HttpStatus.OK);

		return response;

	}

	public StudentResponse<List<Student>> fetchAll() {
		List<Student> fetchAll = studentDao.fetchAll();

		StudentResponse<List<Student>> response = new StudentResponse<>();
		response.setData(fetchAll);
		response.setMsg("Data Fetched");
		response.setHttpStatus(HttpStatus.OK);

		return response;

	}

	public StudentResponse<?> findByPhoneno(long phoneno) {
		Student findByPhoneno = studentDao.findByPhoneno(phoneno);
		
		StudentResponse<Student> response = new StudentResponse<>();
		response.setData(findByPhoneno);
		response.setMsg("Data Fetched by phoneno");
		response.setHttpStatus(HttpStatus.OK);
		
		return response;
	}

	public StudentResponse<?> insertInBatch(List<Student> student) {
		int[] insertInBatch = studentDao.insertInBatch(student);
		
		StudentResponse<int[]> response = new StudentResponse<>();
		response.setData(insertInBatch);
		response.setMsg("Data Fetched by phoneno");
		response.setHttpStatus(HttpStatus.OK);
		
		return response;
		
		
	}

}
