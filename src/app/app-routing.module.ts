import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {EmploymentListComponent } from './employment-list/employment-list.component';

const routes: Routes = [
  { path: 'employees', component: EmploymentListComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}
