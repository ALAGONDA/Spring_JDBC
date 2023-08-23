package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.demo.dao.EmployeeDao;
import com.example.demo.dto.Employee;
import com.example.demo.response.EmployeeResponse;
import com.example.demo.response.StudentResponse;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;

	public EmployeeResponse<Integer> insert(Employee employee) {
		int insert = employeeDao.insert(employee);

		EmployeeResponse<Integer> employeeResponse = new EmployeeResponse<>();
		employeeResponse.setData(insert);
		employeeResponse.setMsg("Data inserted");
		employeeResponse.setHttpStatus(HttpStatus.OK);

		return employeeResponse;

	}

	public EmployeeResponse<Integer> modify(Employee employee) {
		int modify = employeeDao.modify(employee);

		EmployeeResponse<Integer> employeeResponse = new EmployeeResponse<>();
		employeeResponse.setData(modify);
		employeeResponse.setMsg("Data modified");
		employeeResponse.setHttpStatus(HttpStatus.OK);

		return employeeResponse;

	}

	public EmployeeResponse<Integer> dropRow(int id) {
		int dropRow = employeeDao.dropRow(id);
		
		EmployeeResponse<Integer> employeeResponse = new EmployeeResponse<>();
		employeeResponse.setData(dropRow);
		employeeResponse.setMsg("Data dropped");
		employeeResponse.setHttpStatus(HttpStatus.OK);
		
		return employeeResponse;
		
	}

	public EmployeeResponse<List<Employee>> fetch() {
		List<Employee> fetch = employeeDao.fetch();
		
		EmployeeResponse<List<Employee>> employeeResponse = new EmployeeResponse<>();
		employeeResponse.setData(fetch);
		employeeResponse.setMsg("Data Fetched");
		employeeResponse.setHttpStatus(HttpStatus.OK);
		
		return employeeResponse;
		
	}

	public EmployeeResponse<?> fetchById(int id) {
		 Employee fetchById = employeeDao.fetchById(id);
		
		 EmployeeResponse employeeResponse  = new EmployeeResponse<>();
		employeeResponse.setData(fetchById);
		employeeResponse.setMsg("Data fetched by id");
		employeeResponse.setHttpStatus(HttpStatus.OK);
		
		return employeeResponse;
		
		
	}

	public EmployeeResponse<?> insertInList(List<Employee> employees) {
		 int[] insertInList = employeeDao.insertInList(employees);
		
		 EmployeeResponse<int[]> employeeResponse  = new EmployeeResponse<>();
		 
			employeeResponse.setData(insertInList);
			employeeResponse.setMsg("List inserttion done");
			employeeResponse.setHttpStatus(HttpStatus.OK);
			
			return employeeResponse;
	}


	

}
