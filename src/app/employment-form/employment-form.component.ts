import { Component, OnInit } from '@angular/core';
import { EmployeeService } from '../employee.service';
import { employee } from '../app.module';
@Component({
  selector: 'app-employment-form',
  standalone: false,
  templateUrl: './employment-form.component.html',
    styleUrls: ['./employment-form.component.css']  
})
export class EmploymentFormComponent implements OnInit{
  employees: employee[] = [];
  selectedEmployee?: employee;
  newEmployee: employee = {
  name: '',
  age: 0,
  departid: 0,
  roleid: 0,
  projectid: []
};
  selectedId = 0;
  roleId = 0;
  deptId = 0;
  projectIds: number[] = [];

  constructor(private empService: EmployeeService) {}

  ngOnInit(): void {
    this.getAll();
  }

  getAll(): void {
    this.empService.getall().subscribe(data => this.employees = data);
  }

  getById(): void {
    this.empService.getbyId(this.selectedId).subscribe(emp => this.selectedEmployee = emp);
  }

  addEmployee(): void {
  this.empService.create(this.newEmployee).subscribe({
    next: (response) => {
      alert('✅ Employee added successfully!');
      this.getAll(); // Refresh employee list
    
    },
    error: (err) => {
      alert('❌ Failed to add employee.');
      console.error(err);
    }
  });
}


  update(): void {
    if (this.selectedId) {
      this.empService.update(this.selectedId, this.newEmployee).subscribe(() => this.getAll());
    }
  }

  delete(): void {
    if (this.selectedId) {
      this.empService.delete(this.selectedId).subscribe(() => this.getAll());
    }
  }

  assignRole(): void {
    this.empService.assignRole(this.selectedId, this.roleId).subscribe(() => this.getAll());
  }

  assignDepartment(): void {
    this.empService.assignDepartment(this.selectedId, this.deptId).subscribe(() => this.getAll());
  }

  assignProjects(): void {
    this.empService.assignProjects(this.selectedId, this.projectIds).subscribe(() => this.getAll());
  }

  findByDepartment(): void {
    this.empService.findByDepartment(this.deptId).subscribe(data => this.employees = data);
  }

  findByRole(): void {
    this.empService.findByRole(this.roleId).subscribe(data => this.employees = data);
  }

  findByProject(): void {
    if (this.projectIds.length) {
      this.empService.findByProject(this.projectIds[0]).subscribe(data => this.employees = data);
    }
  }

}


