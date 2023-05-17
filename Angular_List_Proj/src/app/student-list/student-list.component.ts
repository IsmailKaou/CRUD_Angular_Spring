import { Component, OnInit } from '@angular/core';
import { Student } from './student.model';
import { StudentListService } from '../services/student-list.service';
import { MatDialog } from '@angular/material/dialog';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.css'],
})
export class StudentListComponent implements OnInit {
  term: string = '';
  genderL: string = '';
  status: string = '';

  active: string = 'link-success';
  students: Student[] = [];
  constructor(
    private studentService: StudentListService,
    private dialogRef: MatDialog,
    private route: ActivatedRoute,
    private router: Router
  ) {}
  ngOnInit(): void {
    this.studentService.FetchAllStudents().subscribe(
      (res) => {
        console.log('Im getting students');

        console.log(res);
        this.students = res;
      },
      (err) => {
        console.log(err);
      }
    );
  }

  FetchAllStudents() {
    this.studentService.FetchAllStudents().subscribe(
      (res) => {
        console.log('Im getting students');

        console.log(res);
        this.students = res;
      },
      (err) => {
        console.log(err);
      }
    );
  }

  Delete(id: string) {
    this.studentService.DeleteById(Number(id)).subscribe(
      (res) => {
        console.log(res);
        this.FetchAllStudents();
      },
      (err) => {
        console.log(err);
      }
    );
  }

  NameChanged(name: string) {
    this.term = name;
  }
  GenderChanged(gender: string) {
    this.genderL = gender;
  }

  StatusChanged(status: string) {
    console.log(status);
    this.status = status;
  }
  addStudent() {
    this.router.navigate(['addStudent'], { relativeTo: this.route });
  }
}
