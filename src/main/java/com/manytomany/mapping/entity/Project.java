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
@Table(name = "project_details")
public class Project {
	@Id
	@Column(name="Pro_Id")
	private int proId;
	@Column(name = "Name")
	private String proName;
	@ManyToMany(mappedBy = "projects", cascade = CascadeType.ALL)
	
	private List<Employee> employees;
	
	public int getProId() {
		return proId;
	}
	public void setProId(int proId) {
		this.proId = proId;
	}
	public String getProName() {
		return proName;
	}
	public void setProName(String proName) {
		this.proName = proName;
	}
	public List<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
	@Override
	public String toString() {
		return "Project [proId=" + proId + ", proName=" + proName + ", employees=" + employees + "]";
	}
	
}
