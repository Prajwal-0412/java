package com.simple.employee.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simple.employee.entityDTO.Employee;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Integer> {

	public Employee findByEmpId(Integer empId);
	
	public Employee findByMail(String mail);
	
}
