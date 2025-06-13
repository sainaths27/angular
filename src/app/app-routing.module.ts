import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {EmploymentListComponent } from './employment-list/employment-list.component';
import { EmploymentFormComponent } from './employment-form/employment-form.component';
import { HomeComponent } from './home/home.component';

const routes: Routes = [
 { path: '', component: HomeComponent},
  { path: 'employee-list', component: EmploymentListComponent},
  { path: 'employee-form', component:EmploymentFormComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
