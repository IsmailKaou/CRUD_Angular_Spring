import { Component, OnInit } from '@angular/core';
import { AuthServiceService } from './services/auth-service.service';
import { StudentListService } from './services/student-list.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent implements OnInit {
  title = 'Angular_List_Proj';
  role!: string;
  constructor(
    private serviceAuth: AuthServiceService,
    private studentList: StudentListService
  ) {}
  ngOnInit(): void {}

  OnChangeRole() {
    this.serviceAuth.setRole(this.role);
  }
}
