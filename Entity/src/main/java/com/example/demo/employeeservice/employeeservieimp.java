package com.example.demo.employeeservice;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.EntityApplication;
import com.example.demo.department.department;
import com.example.demo.departmentrepo.departrepo;
import com.example.demo.employee.employee;
import com.example.demo.employeerepo.employeerepo;
import com.example.demo.project.project;
import com.example.demo.projectrepo.projectrepo;
import com.example.demo.role.role;
import com.example.demo.rolerepo.rolerepo;

@Service
public class employeeservieimp implements employeeservice {

    private final EntityApplication entityApplication;

    

	@Autowired
	private employeerepo er;
	@Autowired
	private departrepo dr;
	@Autowired
	private rolerepo rr;
	@Autowired
	private projectrepo pr;

    employeeservieimp(EntityApplication entityApplication) {
        this.entityApplication = entityApplication;
    }
	
	@Override
	public employee create(employee emp) {
		// TODO Auto-generated method stub
		return er.save(emp);
	}

	@Override
	public employee update(int id, employee emp) {
		// TODO Auto-generated method stub
		emp.setId(id);
		return  er.save(emp) ;
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
er.deleteById(id);
	}

	@Override
	public Optional<employee> getById(Integer id) {
		// TODO Auto-generated method stub
		return er.findById(id);
	}

	@Override
	public List<employee> getAll() {
		// TODO Auto-generated method stub
		return er.findAll();
	}

	@Override
	public List<employee> getByDepartment(int Id) {
		// TODO Auto-generated method stub
		return er.findByDepartmentId(Id);
	}

	@Override
	public List<employee> getByRole(int Id) {
		// TODO Auto-generated method stub
		return er.findByRoleId(Id);
	}

	@Override
	public List<employee> getByProject(int Id) {
		// TODO Auto-generated method stub
		return er.findByProjectsId(Id);
	}

	@Override
	public employee assignDepartment(int  empId, int deptId) {
		// TODO Auto-generated method stub
		department dept = dr.findById(deptId)
			    .orElseThrow(() -> new RuntimeException("Department not found"));
		Optional<employee> optionalemp = getById(empId);
		employee emp = er.findById(empId)
		        .orElseThrow(() -> new RuntimeException("Employee not found"));
		emp.setdepartment(dept);
		return  er.save(emp);

	}

	@Override
	public employee assignRole(int empId, int roleId) {
	    // Fetch employee
	    employee emp = er.findById(empId)
	            .orElseThrow(() -> new RuntimeException("Employee not found"));

	    // Fetch role
	    role role = rr.findById(roleId)
	            .orElseThrow(() -> new RuntimeException("Role not found"));

	    // Assign role and save
	    emp.setrole(role);
	    return er.save(emp);
	}


	@Override
	public employee assignProjects(int empId, List<Integer> projectIds) {
		// TODO Auto-generated method stub
		employee emp = er.findById(empId).orElseThrow(() -> new RuntimeException("Employee not found"));
		 Set<project> projects = new HashSet<>(pr.findAllById(projectIds));
	        emp.setProjects(projects);
		return er.save(emp);
	}

}
