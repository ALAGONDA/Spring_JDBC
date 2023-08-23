package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Student;
import com.example.demo.response.StudentResponse;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping("/app")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@PostMapping("/insertrow")
	public StudentResponse<?> newEntry(@RequestBody Student student) {
		StudentResponse<?> insert = studentService.insert(student);
		return insert;

	}

	@PutMapping("/updatedata")
	public StudentResponse<?> modify(@RequestBody Student student) {
		StudentResponse<?> modify = studentService.modify(student);

		return modify;

	}

	@DeleteMapping("/deleteById/{phoneno}")
	public StudentResponse<?> deleteByPhoneno(@PathVariable long phoneno) {
		StudentResponse<?> deleteByPhoneno = studentService.deleteByPhoneno(phoneno);
		return deleteByPhoneno;

	}

	@GetMapping("/find")
	public StudentResponse<List<Student>> fetchAll() {
		StudentResponse<List<Student>> fetchAll = studentService.fetchAll();
		return fetchAll;
	}

	@GetMapping("/findById/{phoneno}")
	public StudentResponse<?> findByPhoneno(@PathVariable long phoneno) {
		StudentResponse<?> findByPhoneno = studentService.findByPhoneno(phoneno);

		return findByPhoneno;

	}

	@PostMapping("/listInsert")
	public StudentResponse<?> insertInBatch(@RequestBody List<Student> student) {
		StudentResponse<?> response = studentService.insertInBatch(student);
		return response;

	}

}
