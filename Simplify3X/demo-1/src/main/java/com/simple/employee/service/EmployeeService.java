package com.simple.employee.service;

import java.util.List;

import com.simple.employee.entityDTO.Employee;
import com.simple.employee.entityDTO.EmployeeDTO;

public interface EmployeeService {

	public Employee addEmployee(Employee employee);
	
	public EmployeeDTO getEmployee(Integer empId);
	
	public EmployeeDTO getEmployee1(String mail);
	
	public List<EmployeeDTO> getAllEmp(EmployeeDTO employee);
	
	public boolean deleteEmployee(Integer empId);
	
}
