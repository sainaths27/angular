

package com.example.demo.department;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity

@Table(name = "department") 
public class department {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String name;
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
	public department(String name) {
		super();
		this.name = name;
	}
	public department() {
		super();
		// TODO Auto-generated constructor stub
	}
	
@OneToMany(mappedBy ="department")
private List<com.example.demo.employee.employee>employee= new ArrayList<>();
}
