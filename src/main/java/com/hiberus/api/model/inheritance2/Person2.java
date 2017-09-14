package com.hiberus.api.model.inheritance2;

import javax.persistence.*;


@Entity(name = "person2")
@Table(name = "person_2")
@Inheritance(strategy=InheritanceType.JOINED)
/*@DiscriminatorColumn(
		name="discriminator",
		discriminatorType=DiscriminatorType.STRING
)
@DiscriminatorValue(value="P")*/
public class Person2 {

	@Id
	@GeneratedValue
	@Column(name = "person_id")
	private Long personId;
	
	@Column(name = "firstname")
	private String firstname;
	
	@Column(name = "lastname")
	private String lastname;
	
	public Person2() {
	
	}
	public Person2(String firstname, String lastname) {
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
