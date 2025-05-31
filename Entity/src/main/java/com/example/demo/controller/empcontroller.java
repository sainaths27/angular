package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.employee.employee;
import com.example.demo.employeeservice.employeeservice;

@RestController
public class empcontroller {

	@Autowired
	private employeeservice er;
	
	@PostMapping
	public   employee create (@RequestBody employee emp)
	{
		return er.create(emp);
	}
	
	@PutMapping("/{id}")
	public employee update(@PathVariable int id,@RequestBody employee emp)
	{
		return er.update(id, emp);
	}
	  @DeleteMapping("/{id}")
	    public void delete(@PathVariable int  id) {
	        er.delete(id);
	    }
@GetMapping("/{id}")
public Optional<employee> getById(@PathVariable int  id) {
    return er.getById(id);
}	
@GetMapping
public List<employee> getAll() {
    return er.getAll();
}
@PutMapping("/{id}/assign-depart/{id}")
	public employee assignDepartment(@PathVariable int id, @PathVariable int deptId) {
        return er.assignDepartment(id, deptId);
    }

    @PutMapping("/{id}/assign-role/{roleId}")
    public employee assignRole(@PathVariable int  id, @PathVariable int roleId) {
        return er.assignRole(id, roleId);
    }

    @PutMapping("/{id}/assign-projects")
    public employee assignProjects(@PathVariable int id, @RequestBody List<Integer> projectIds) {
        return er.assignProjects(id, projectIds);
    }

    @GetMapping("/department/{deptId}")
    public List<employee> getByDepartment(@PathVariable int deptId) {
        return er.getByDepartment(deptId);
    }

    @GetMapping("/role/{roleId}")
    public List<employee> getByRole(@PathVariable int roleId) {
        return er.getByRole(roleId);
    }

    @GetMapping("/project/{projectId}")
    public List<employee> getByProject(@PathVariable int projectId) {
        return er.getByProject(projectId);
    }

}
