package com.simple.employee.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simple.employee.dao.EmployeeDao;
import com.simple.employee.entityDTO.Employee;
import com.simple.employee.entityDTO.EmployeeDTO;
import com.simple.employee.exception.Exception;

@Service
public class EmployeeServiceImplementationClass implements EmployeeService {

	@Autowired
	public EmployeeDao dao;

	@Autowired
	private ModelMapper mapper;

	@Override
	public Employee addEmployee(Employee employee) {
		if (employee.getEmpId() <= 0) {
			throw new Exception("Enter Valid Employee Id");
		}
		return dao.save(employee);

	}

	@Override
	public EmployeeDTO getEmployee(Integer empId) {
		if (empId <= 0) {
			throw new Exception("Enter Valid Employee Id");
		}
		Employee employee = dao.findByEmpId(empId);
		if (employee != null) {
			EmployeeDTO dto = mapper.map(employee, EmployeeDTO.class);
			return dto;
		}
		throw new Exception("The Employee You are searching with the empId doesnot exist");
	}

	@Override
	public EmployeeDTO getEmployee1(String mail) {
		Employee employee = dao.findByMail(mail);
		if(employee!=null) {
		EmployeeDTO dto = mapper.map(employee, EmployeeDTO.class);
		return dto;
		}
		throw new Exception("The Employee You are searching for doesnot exist");
	}

	public EmployeeDTO findAllEmp(Employee employee) {
		EmployeeDTO dto = new EmployeeDTO();
		dto.setEmpId(employee.getEmpId());
		dto.setEmpName(employee.getEmpName());
		dto.setCompName(employee.getCompName());
		return dto;
	}

	@Override
	public List<EmployeeDTO> getAllEmp(EmployeeDTO employee) {
		List<Employee> emp = dao.findAll();
		return emp.stream().map(this::findAllEmp).collect(Collectors.toList());
	}

	@Override
	public boolean deleteEmployee(Integer empId) {
		Employee employee = dao.findByEmpId(empId);
		if (employee != null) {
			dao.delete(employee);
			return true;
		} else {
			return false;
		}
	}

}
