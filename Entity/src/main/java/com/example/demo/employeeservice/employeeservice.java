package com.example.demo.employeeservice;

import java.util.List;
import java.util.Optional;

import com.example.demo.employee.employee;

public interface employeeservice {
	employee create(employee emp);
    employee update(int id, employee emp);
    void delete(Integer id);
    Optional<employee> getById(Integer id);
    List<employee> getAll();
    List<employee> getByDepartment(int Id);
    List<employee> getByRole(int Id);
    List<employee> getByProject(int Id);
    employee assignDepartment(int  empId, int Id);
    employee assignRole(int empId, int roleId);
    employee assignProjects(int empId, List<Integer> projectIds);
}
