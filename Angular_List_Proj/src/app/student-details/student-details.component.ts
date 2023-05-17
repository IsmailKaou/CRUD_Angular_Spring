import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Student } from '../student-list/student.model';
import { StudentListService } from '../services/student-list.service';
import {
  FormBuilder,
  FormControl,
  FormGroup,
  Validators,
} from '@angular/forms';

@Component({
  selector: 'app-student-details',
  templateUrl: './student-details.component.html',
  styleUrls: ['./student-details.component.css'],
})
export class StudentDetailsComponent implements OnInit {
  id!: number;
  student: Student;
  updateForm: FormGroup;
  name: string;
  resMsg: string;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private studentService: StudentListService,
    private builder: FormBuilder
  ) {
    this.updateForm = new FormGroup({
      name: new FormControl(null, Validators.required),
      gender: new FormControl(null, Validators.required),
      mark: new FormControl(null, Validators.required),
      birthDate: new FormControl(null, Validators.required),
    });
  }

  ngOnInit(): void {
    this.id = Number(this.route.snapshot.paramMap.get('id'));
    this.studentService.FetchStudentById(this.id).subscribe(
      (res) => {
        console.log('im getting a student');
        console.log(res);

        this.student = res[0];
        console.log(this.student.name);
        // this.name = this.student.name;
        const birthDateD = new Date(this.student.birthDate);
        this.updateForm = new FormGroup({
          name: new FormControl(this.student.name, Validators.required),
          gender: new FormControl(this.student.gender, Validators.required),
          mark: new FormControl(this.student.mark, Validators.required),
          birthDate: new FormControl(
            birthDateD.toISOString().substr(0, 10),
            Validators.required
          ),
        });
      },
      (err) => {
        console.log(err);
      }
    );
  }
  onSubmit(FormData: any) {
    if (!this.updateForm.valid) {
      return;
    } else {
      const name = FormData.name;
      const gender = FormData.gender;
      const birthDate = FormData.birthDate;
      const mark = FormData.mark;

      const body = {
        name: name,
        mark: mark,
        birthDate: birthDate,
        gender: gender,
      };
      const headers = { 'Content-Type': 'application/json' };
      this.studentService
        .UpdateStudent(Number(this.student.id), body, headers)
        .subscribe(
          (res) => {
            console.log(res);
            this.resMsg = 'Student updated Successfully';
          },
          (err) => {
            console.log(err);
          }
        );
    }
  }
}
