import { Component } from '@angular/core';
import {
  FormBuilder,
  FormControl,
  FormGroup,
  Validators,
} from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { StudentListService } from 'src/app/services/student-list.service';

@Component({
  selector: 'app-add-student',
  templateUrl: './add-student.component.html',
  styleUrls: ['./add-student.component.css'],
})
export class AddStudentComponent {
  id!: number;
  createForm: FormGroup;
  name: string;
  resMsg: string;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private studentService: StudentListService,
    private builder: FormBuilder
  ) {
    this.createForm = new FormGroup({
      name: new FormControl(null, Validators.required),
      gender: new FormControl(null, Validators.required),
      mark: new FormControl(null, Validators.required),
      birthDate: new FormControl(null, Validators.required),
    });
  }

  ngOnInit(): void {}
  onSubmit(FormData: any) {
    if (!this.createForm.valid) {
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
      this.studentService.AddStudent(body, headers).subscribe(
        (res) => {
          this.resMsg = 'Student added successfully';
        },
        (err) => {
          console.log('error adding student');
        }
      );
    }
  }
}
