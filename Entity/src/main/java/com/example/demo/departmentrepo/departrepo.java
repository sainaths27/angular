package com.example.demo.departmentrepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.department.department;

public interface departrepo extends JpaRepository<department, Integer> {

}
