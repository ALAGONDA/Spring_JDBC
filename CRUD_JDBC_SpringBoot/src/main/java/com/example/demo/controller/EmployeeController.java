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

import com.example.demo.dto.Employee;
import com.example.demo.response.EmployeeResponse;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/app")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/add")
	public EmployeeResponse<Integer> insert(@RequestBody Employee employee) {
		EmployeeResponse<Integer> insert = employeeService.insert(employee);
		return insert;
	}
	
	@PutMapping("/update")
	public EmployeeResponse<Integer> modify(@RequestBody Employee employee) {
		EmployeeResponse<Integer> modify = employeeService.modify(employee);
		return modify;	
	}
	
	@DeleteMapping("/delete/{id}")
	public EmployeeResponse<Integer> dropRow(@PathVariable int id) {
		EmployeeResponse<Integer> dropRow = employeeService.dropRow(id);
		return dropRow;
	}
	
	@GetMapping("/fetchEmployees")
	public EmployeeResponse<List<Employee>> getEmployees() {
		EmployeeResponse<List<Employee>> fetch = employeeService.fetch();
		
		return fetch;
		
	}
	
	@GetMapping("/fetchById/{id}")
	public EmployeeResponse fetchById(@PathVariable int id) {
		EmployeeResponse fetchById = employeeService.fetchById(id);
		return fetchById;
	}
	
	@PostMapping("/listEmployees")
	public EmployeeResponse insertInList(@RequestBody List<Employee> employees) {
		EmployeeResponse insertInList = employeeService.insertInList(employees);
		return insertInList;
	}

}
