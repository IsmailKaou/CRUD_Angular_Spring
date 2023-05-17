import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';

import { AppComponent } from './app.component';
import { StudentListComponent } from './student-list/student-list.component';
import { SearchHeaderComponent } from './search-header/search-header.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { FilterByName } from './student-list/FilterByName';
import { FilterByGender } from './student-list/FilterByGender';
import { FilterByStatus } from './student-list/FilterByStatus';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { NavbarComponent } from './navbar/navbar.component';
import { StudentDetailsComponent } from './student-details/student-details.component';
import { AuthGardGuard } from './auth-gard.guard';
import { LoginFormComponent } from './login-form/login-form.component';
import { ProfListComponent } from './prof-list/prof-list.component';
import { HttpClientModule } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatDialogModule } from '@angular/material/dialog';
import { AddStudentComponent } from './student-list/add-student/add-student.component';
import { AddProfessorComponent } from './prof-list/add-professor/add-professor.component';
import { ProfessorDetailsComponent } from './professor-details/professor-details.component';
const appRoutes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'students', component: StudentListComponent },
  { path: 'students/addStudent', component: AddStudentComponent },
  {
    path: 'students/:id',
    component: StudentDetailsComponent,
    canActivate: [AuthGardGuard],
  },
  { path: 'professors', component: ProfListComponent },
  { path: 'professors/addProfessor', component: AddProfessorComponent },
  {
    path: 'professors/:id',
    component: ProfessorDetailsComponent,
  },
  { path: '**', component: StudentListComponent },
  { path: 'logIn', component: LoginFormComponent },
];

@NgModule({
  declarations: [
    AppComponent,
    StudentListComponent,
    SearchHeaderComponent,
    FilterByName,
    FilterByGender,
    FilterByStatus,
    HomeComponent,
    NavbarComponent,
    StudentDetailsComponent,
    LoginFormComponent,
    ProfListComponent,
    AddStudentComponent,
    AddProfessorComponent,
    ProfessorDetailsComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    AppRoutingModule,
    HttpClientModule,
    RouterModule.forRoot(appRoutes),
    ReactiveFormsModule,
    BrowserAnimationsModule,
    MatDialogModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
