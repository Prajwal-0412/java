package com.simple.employee.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.simple.employee.entityDTO.Employee;
import com.simple.employee.entityDTO.EmployeeDTO;
import com.simple.employee.exception.Response;
import com.simple.employee.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService service;


	@PostMapping("/add")
	public ResponseEntity<Response> addEmployee(@RequestBody Employee employee) {
		Response response = new Response();
		Employee employee1 = service.addEmployee(employee);
		if (employee1 != null) {
			response.setError(false);
			response.setErrMessage("Employee Added into database Successfully");
			response.setObject(employee1);
			return new ResponseEntity<Response>(response, HttpStatus.OK);
		} else {
			response.setError(true);
			response.setErrMessage("Employee Not Added");
			return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/getById/{empId}")
	public ResponseEntity<Response> getEmployee(@PathVariable Integer empId) {
		Response response = new Response();
		EmployeeDTO employee = service.getEmployee(empId);
		if (employee != null) {
			response.setError(false);
			response.setErrMessage("Employee with empId " + empId + " is found and his details are");
			response.setObject(employee);
			return new ResponseEntity<Response>(response, HttpStatus.OK);
		} else {
			response.setError(true);
			response.setErrMessage("There are no employees found with the given empId " + empId);
			return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/getByMail/{mail}")
	public ResponseEntity<Response> getEmployee1(@PathVariable String mail) {
		Response response = new Response();
		EmployeeDTO employee = service.getEmployee1(mail);
		if (employee != null) {
			response.setError(false);
			response.setErrMessage("Employee with email " + mail + " has been found successfully");
			response.setObject(employee);
			return new ResponseEntity<Response>(response, HttpStatus.OK);
		} else {
			response.setError(true);
			response.setErrMessage("There are no employees found with the given mail " + mail);
			return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/deleteById/{empId}")
	public ResponseEntity<Response> deleteEmployee(@PathVariable Integer empId) {
		Response response = new Response();
		if (service.deleteEmployee(empId)) {
			response.setError(true);
			response.setErrMessage("Employee Deleted Successfully");
			return new ResponseEntity<Response>(response, HttpStatus.OK);
		} else {
			response.setError(true);
			response.setErrMessage("There are no employees found with the given empId " + empId);
			return new ResponseEntity<Response>(response, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/displayAll")
	public ResponseEntity<Response> displayAll(EmployeeDTO employee) {
		Response response = new Response();
		List<EmployeeDTO> employees = service.getAllEmp(employee);
		if (employees != null) {
			response.setError(false);
			response.setErrMessage("List of Employees Working in the given company");
			response.setObject(employees);
			return new ResponseEntity<Response>(response, HttpStatus.OK);
		} else {
			response.setError(true);
			response.setErrMessage("Server Error ");
			return new ResponseEntity<Response>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
