import { Component } from '@angular/core';
import { ProfListService } from '../services/prof-list.service';
import { MatDialog } from '@angular/material/dialog';
import { ActivatedRoute, Router } from '@angular/router';
import { Prof } from './Prof.model';

@Component({
  selector: 'app-prof-list',
  templateUrl: './prof-list.component.html',
  styleUrls: ['./prof-list.component.css'],
})
export class ProfListComponent {
  profs: Prof[] = [];
  constructor(
    private profService: ProfListService,
    private dialogRef: MatDialog,
    private route: ActivatedRoute,
    private router: Router
  ) {}
  ngOnInit(): void {
    this.profService.FetchAllProfs().subscribe(
      (res) => {
        console.log('Im getting profs');

        console.log(res);
        this.profs = res;
      },
      (err) => {
        console.log(err);
      }
    );
  }

  FetchAllProfs() {
    this.profService.FetchAllProfs().subscribe(
      (res) => {
        console.log('Im getting profs');

        console.log(res);
        this.profs = res;
      },
      (err) => {
        console.log(err);
      }
    );
  }

  Delete(id: string) {
    this.profService.DeleteById(Number(id)).subscribe(
      (res) => {
        console.log(res);
        this.FetchAllProfs();
      },
      (err) => {
        console.log(err);
      }
    );
  }
}
