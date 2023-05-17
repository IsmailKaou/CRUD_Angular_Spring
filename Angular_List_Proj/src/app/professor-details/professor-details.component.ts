import { Component } from '@angular/core';
import {
  FormBuilder,
  FormControl,
  FormGroup,
  Validators,
} from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ProfListService } from '../services/prof-list.service';
import { Prof } from '../prof-list/Prof.model';

@Component({
  selector: 'app-professor-details',
  templateUrl: './professor-details.component.html',
  styleUrls: ['./professor-details.component.css'],
})
export class ProfessorDetailsComponent {
  id!: number;
  prof: Prof;
  updateForm: FormGroup;
  resMsg: string;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private profService: ProfListService,
    private builder: FormBuilder
  ) {
    this.updateForm = new FormGroup({
      firstName: new FormControl(null, Validators.required),
      lastName: new FormControl(null, Validators.required),
      email: new FormControl(null, Validators.required),
    });
  }

  ngOnInit(): void {
    this.id = Number(this.route.snapshot.paramMap.get('id'));
    this.profService.FetchProfById(this.id).subscribe(
      (res) => {
        console.log('im getting a prof');
        console.log(res);

        this.prof = res[0];

        // console.log(this.prof.firstName);
        // console.log(this.prof.email);

        // this.name = this.prof.name;
        this.updateForm = new FormGroup({
          firstName: new FormControl(this.prof.firstName, Validators.required),
          lastName: new FormControl(this.prof.lastName, Validators.required),
          email: new FormControl(this.prof.email, Validators.required),
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
      const firstName = FormData.firstName;
      const lastName = FormData.lastName;
      const email = FormData.email;
      console.log(firstName);

      const body = {
        firstName: firstName,
        email: email,
        lastName: lastName,
      };
      const headers = { 'Content-Type': 'application/json' };
      this.profService
        .UpdateProf(Number(this.prof.id), body, headers)
        .subscribe(
          (res) => {
            console.log(res);
            this.resMsg = 'Prof updated Successfully';
          },
          (err) => {
            console.log(err);
          }
        );
    }
  }
}
