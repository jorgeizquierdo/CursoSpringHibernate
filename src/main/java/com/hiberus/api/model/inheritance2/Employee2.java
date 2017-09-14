package com.hiberus.api.model.inheritance2;

import java.util.Date;

import javax.persistence.*;

@Entity(name="employee2")
@Table(name="employee_2")
//@DiscriminatorValue(value="E")
@PrimaryKeyJoinColumn(name="person_id")
public class Employee2 extends Person2 {

	@Column(name="joining_date")
	private Date joiningDate;
	
	@Column(name="department_name")
	private String departmentName;

	public Employee2() {
	}
	
	public Employee2(String firstname, String lastname, String departmentName, Date joiningDate) {
		
		super(firstname, lastname);
		
		this.departmentName = departmentName;
		this.joiningDate = joiningDate;
	}
	
	public Date getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
}
