import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { employee } from './app.module';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  private baseUrl = 'http://localhost:8080/employees';

  constructor(private http: HttpClient) {}

  getall(): Observable<employee[]> {
    return this.http.get<employee[]>(`${this.baseUrl}`);
  }

  getbyId(id: number): Observable<employee> {
    return this.http.get<employee>(`${this.baseUrl}/${id}`);
  }

  create(emp: employee): Observable<employee> {
    return this.http.post<employee>(this.baseUrl, emp);
  }

  update(id: number, emp: employee): Observable<employee> {
    return this.http.put<employee>(`${this.baseUrl}/${id}`, emp); // ✅ use PUT
  }

  delete(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/${id}`);
  }

  assignRole(empId: number, roleId: number): Observable<employee> {
    return this.http.put<employee>(`${this.baseUrl}/${empId}/role/${roleId}`, {});
  }

  assignDepartment(empId: number, deptId: number): Observable<employee> {
    return this.http.put<employee>(`${this.baseUrl}/${empId}/department/${deptId}`, {});
  }

  assignProjects(empId: number, projectIds: number[]): Observable<employee> {
    return this.http.put<employee>(`${this.baseUrl}/${empId}/projects`, projectIds);
  }

  findByDepartment(deptId: number): Observable<employee[]> {
    return this.http.get<employee[]>(`${this.baseUrl}/department/${deptId}`);
  }

  findByRole(roleId: number): Observable<employee[]> {
    return this.http.get<employee[]>(`${this.baseUrl}/role/${roleId}`);
  }

  findByProject(projectId: number): Observable<employee[]> {
    return this.http.get<employee[]>(`${this.baseUrl}/project/${projectId}`);
  }
  
}
