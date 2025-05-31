package com.example.demo.employee;

import java.util.HashSet;
import java.util.Set;

import com.example.demo.department.department;
import com.example.demo.project.project;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "employee") 
public class employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String name;
	private int  age;
	private float salary;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	public employee(String name, int age, float salary) {
		super();
		this.name = name;
		this.age = age;
		this.salary = salary;
	}
	public employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	@ManyToOne
	private department department ;
	
	
	@ManyToOne
	private com.example.demo.role.role role;
	
	@ManyToMany
	private Set<project> project = new HashSet<>();
	public void setdepartment(department department) {
	    this.department = department;
	}
	public void setrole(com.example.demo.role.role role) {
	    this.role = role;
	}
	public void setProjects(Set<com.example.demo.project.project> projects) {
		// TODO Auto-generated method stub
		this.project=project;
	}


}
