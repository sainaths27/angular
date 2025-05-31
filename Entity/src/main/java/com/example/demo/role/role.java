package com.example.demo.role;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.employee.employee;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
@Entity
@Table(name = "role") 
public class role {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String title;
	 @OneToMany(mappedBy = "role")
	    private List<employee> employees = new ArrayList<>();
}
