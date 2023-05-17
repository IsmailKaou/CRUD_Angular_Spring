import { Injectable } from '@angular/core';
import { Prof } from '../prof-list/Prof.model';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class ProfListService {
  profs: Prof[] = [];
  constructor(private httpService: HttpClient) {}

  public FetchAllProfs() {
    return this.httpService.get<Prof[]>('/apis/professor/getProfessors');
  }
  public FetchProfById(id: number) {
    return this.httpService.get<Prof>(`/apis/professor/getProfessors/${id}`);
  }
  public DeleteById(id: number) {
    return this.httpService.delete(`/apis/professor/delete/${id}`);
  }
  public UpdateProf(id: number, body: any, headers: any) {
    return this.httpService.post<Response>(
      `/apis/professor/update/${id}`,
      body,
      headers
    );
  }
  public AddProf(body: any, headers: any) {
    return this.httpService.post<Response>(
      '/apis/professor/save',
      body,
      headers
    );
  }
}
