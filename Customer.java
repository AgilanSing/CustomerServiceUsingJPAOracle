package com.customerservice.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "CUST_TABLE")
@EntityListeners(AuditingEntityListener.class)
public class Customer {
    @Column(name = "ID")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @ApiModelProperty(notes = "Unique identifier of the Customer.", example = "1", required = true, position = 0)
    private Integer id;

    @NotBlank
	@NotNull
    @Column(name = "First_Name", nullable = false)
    @Pattern(regexp = "^[a-zA-Z]{5,10}", message = "length between 5 and 10")
	@ApiModelProperty(notes = "Customer first Name", example = "Agilan", required = true, position = 1)
	@Size(max = 10, min = 5)
    private String firstName;

    @NotBlank
	@NotNull
	@Pattern(regexp = "^[a-zA-Z]{5,10}", message = "length between 5 and 10")
	@ApiModelProperty(notes = "Customer Last Name", example = "S", required = true, position = 2)
	@Size(max = 10, min = 5)
    @Column(name = "Last_Name", nullable = false)
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