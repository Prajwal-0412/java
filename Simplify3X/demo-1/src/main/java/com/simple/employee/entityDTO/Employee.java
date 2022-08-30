package com.simple.employee.entityDTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "emp_details")
public class Employee {

	@Id
	@Column(name = "id")
	private Integer empId;
	@Column(name = "name")
	private String empName;
	@Column(name = "company")
	private String compName;
	@Column(name = "aadhar")
	private Integer aadharNo;
	@Column(name = "e_mail")
	private String mail;

}
