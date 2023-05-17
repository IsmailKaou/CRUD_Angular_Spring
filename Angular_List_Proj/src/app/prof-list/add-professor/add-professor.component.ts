import { Component } from '@angular/core';
import {
  FormBuilder,
  FormControl,
  FormGroup,
  Validators,
} from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ProfListService } from 'src/app/services/prof-list.service';
import { StudentListService } from 'src/app/services/student-list.service';

@Component({
  selector: 'app-add-professor',
  templateUrl: './add-professor.component.html',
  styleUrls: ['./add-professor.component.css'],
})
export class AddProfessorComponent {
  id!: number;
  createForm: FormGroup;
  resMsg: string;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private studentService: ProfListService,
    private builder: FormBuilder
  ) {
    this.createForm = new FormGroup({
      firstName: new FormControl(null, Validators.required),
      lastName: new FormControl(null, Validators.required),
      email: new FormControl(null, [Validators.required, Validators.email]),
    });
  }

  ngOnInit(): void {}
  onSubmit(FormData: any) {
    if (!this.createForm.valid) {
      return;
    } else {
      const firstName = FormData.firstName;
      const lastName = FormData.lastName;
      const email = FormData.email;

      const body = {
        firstName: firstName,
        lastName: lastName,
        email: email,
      };
      const headers = { 'Content-Type': 'application/json' };
      this.studentService.AddProf(body, headers).subscribe(
        (res) => {
          this.resMsg = 'Professor added successfully';
        },
        (err) => {
          console.log('error adding Professor');
        }
      );
    }
  }
}
