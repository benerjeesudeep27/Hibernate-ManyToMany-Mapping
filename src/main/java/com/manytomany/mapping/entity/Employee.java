package com.manytomany.mapping.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
@Entity
@Table(name = "employee_details")
public class Employee {
	@Id
	@Column(name = "Emp_Id")
	private int empId;
	@Column(name = "Name")
	private String empName;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Assignment", 
	joinColumns = {
			@JoinColumn(name = "ProId")},
			inverseJoinColumns = {@JoinColumn(name="EmpId")}
	)
	private List<Project> projects;
	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public List<Project> getProjects() {
		return projects;
	}
	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", projects=" + projects + "]";
	}
	
}
