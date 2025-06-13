import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { EmploymentListComponent } from './employment-list/employment-list.component';
import { EmploymentFormComponent } from './employment-form/employment-form.component';
import { HttpClientModule } from '@angular/common/http';
import { HomeComponent } from './home/home.component';
@NgModule({
  declarations: [
    AppComponent,
    
    EmploymentListComponent,
    EmploymentFormComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {


 }
 export interface  employee{
  id? :number;
  name:string;
  age:number;
  departid:number;
  roleid:number;
  projectid:number[];
 }
