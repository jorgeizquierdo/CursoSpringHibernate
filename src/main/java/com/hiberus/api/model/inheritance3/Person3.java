package com.hiberus.api.model.inheritance3;

import javax.persistence.*;


@Entity(name = "person3")
@Table(name = "person_3")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Person3 {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "person_id")
	private Long personId;
	
	@Column(name = "firstname")
	private String firstname;
	
	@Column(name = "lastname")
	private String lastname;
	
	public Person3() {
	
	}
	public Person3(String firstname, String lastname) {
		this.firstname = firstname;
		this.lastname = lastname;
	}

	public Long getPersonId() {
		return personId;
	}
	public void setPersonId(Long personId) {
		this.personId = personId;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
}
