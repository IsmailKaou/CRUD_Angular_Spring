import { HttpClient } from '@angular/common/http';
import { Injectable, OnInit } from '@angular/core';
import { Student } from '../student-list/student.model';

@Injectable({
  providedIn: 'root',
})
export class StudentListService {
  students: Student[] = [];
  constructor(private httpService: HttpClient) {}

  public FetchAllStudents() {
    return this.httpService.get<Student[]>('/apis/student/getStudents');
  }
  public FetchStudentById(id: number) {
    return this.httpService.get<Student>(`/apis/student/getStudents/${id}`);
  }
  public DeleteById(id: number) {
    return this.httpService.delete(`/apis/student/delete/${id}`);
  }
  public UpdateStudent(id: number, body: any, headers: any) {
    return this.httpService.post<Response>(
      `/apis/student/update/${id}`,
      body,
      headers
    );
  }
  public AddStudent(body: any, headers: any) {
    return this.httpService.post<Response>('/apis/student/save', body, headers);
  }
}
