package com.course.rabbitmqconsumer.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.course.rabbitmqconsumer.json.CustomLocalDateDeserializer;

public class Employee {

	@JsonProperty("id")
	private String employeeId;
	@JsonProperty("name")
	private String employeeName;
	@JsonProperty("birth_date")
	@JsonDeserialize(using = CustomLocalDateDeserializer.class)
	private LocalDate birthDate;

	public Employee() {

	}

	public Employee(String employeeId, String employeeName, LocalDate birthDate) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.birthDate = birthDate;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", birthDate=" + birthDate
				+ "]";
	}

}
