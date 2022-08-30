package com.simple.employee.entityDTO;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class EmployeeDTO {

	private Integer empId;
	private String empName;
	private String compName;
}
