package com.customerservice.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "CUST_TABLE")
public class Customer {
    @Column(name = "ID")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "First_Name", nullable = false, length = 10)
    private String firstName;

    @Column(name = "Last_Name", nullable = false, length = 10)
    private String lastName;
	
	@Column(name = "Gender", nullable = true, length = 10)
    private String gender;
	
	@Column(name = "Age", nullable = true, length = 3)
    private Integer age;
	
	@Column(name = "PhoneNumber", nullable = true, length = 10)
    private Integer phoneNumber;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Integer getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Integer phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setId(Integer id) {
		this.id = id;
	}
   
    @Override
	public String toString() {
		return "Product [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + gender
				+ ", age=" + age + ", phoneNumber=" + phoneNumber + "]";
	}
}