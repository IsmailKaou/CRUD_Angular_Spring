import {Component, EventEmitter, Output} from '@angular/core';

@Component({
  selector: 'app-search-header',
  templateUrl: './search-header.component.html',
  styleUrls: ['./search-header.component.css']
})
export class SearchHeaderComponent {

  @Output() changeName = new EventEmitter<string>();
  @Output() changeGender = new EventEmitter<string>();
  @Output() changeStatus = new EventEmitter<string>();
  name : string = ''
  gender : string = ''
  status : string = ''

  OnChangeName(){
    /*console.log(this.name)*/
    this.changeName.emit(this.name)
  }

  OnChangeGender(){
      /*console.log(this.gender)*/
      this.changeGender.emit(this.gender)
  }

  OnChangeStatus(){
    //console.log(this.status)
    this.changeStatus.emit(this.status)
  }
}
