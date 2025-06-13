import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  standalone: false,
  templateUrl: './home.component.html',
   styleUrl: './home.component.css'
})
export class HomeComponent {
  constructor(private router: Router) {}

  goToEmployeeList() {
    this.router.navigate(['/employee-list']);
  }

  goToEmployeeForm() {
    this.router.navigate(['/employee-form']);
  }
}
