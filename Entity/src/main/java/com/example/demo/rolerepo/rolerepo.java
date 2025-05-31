package com.example.demo.rolerepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.role.role;

public interface rolerepo extends JpaRepository<role, Integer> {
	

}
