import { Component, OnInit } from '@angular/core';
import { employee } from '../app.module';
import { EmployeeService } from '../employee.service';
@Component({
  selector: 'app-employment-list',
  standalone: false,
  templateUrl: './employment-list.component.html',
  styleUrls: ['./employment-list.component.css']
})
export class EmploymentListComponent implements OnInit {
  employee:employee[] =[];
constructor(private empservice:EmployeeService){}
ngOnInit(): void {
  this.loademployees();
}
loademployees():void{
  this.empservice.getall().subscribe(data=>this.employee = data);
}
  delete(id: number): void {
    this.empservice.delete(id).subscribe(() => this.loademployees());
  }
}
