package com.hiberus.api.model.inheritance3;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name="employee3")
@Table(name="employee_3")
@AttributeOverrides({
	@AttributeOverride(name="firstname", column=@Column(name="firstname")),
    @AttributeOverride(name="lastname", column=@Column(name="lastname"))
})
public class Employee3 extends Person3 {

	@Column(name="joining_date")
	private Date joiningDate;
	
	@Column(name="department_name")
	private String departmentName;

	public Employee3() {
	}
	
	public Employee3(String firstname, String lastname, String departmentName, Date joiningDate) {
		
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
