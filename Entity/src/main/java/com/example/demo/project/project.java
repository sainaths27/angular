package com.example.demo.project;

import java.util.HashSet;
import java.util.Set;

import com.example.demo.employee.employee; 

import jakarta.persistence.*;

@Entity
@Table(name = "projects") 
public class project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String projectName;

    @ManyToMany(mappedBy = "projects")
    private Set<employee> employees = new HashSet<>();
}