package com.example.demo.employeerepo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.employee.employee;
import com.example.demo.project.project;
import com.example.demo.role.role;

@Repository
public interface employeerepo extends JpaRepository<employee, Integer> {
	
	    List<employee> findByDepartmentId(int id);
	    List<employee> findByRoleId(int roleId);
	    List<employee> findByProjectsId(int projectId);
	

}
