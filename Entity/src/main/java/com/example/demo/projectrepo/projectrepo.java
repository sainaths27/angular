package com.example.demo.projectrepo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.project.project;

public interface projectrepo extends JpaRepository<project, Integer> {

}
