import {Pipe, PipeTransform} from "@angular/core";

@Pipe({
  name: 'FilterByGender',
})
export class FilterByGender implements PipeTransform {
  transform(items: any[], term: string): any {
    if(term!="All"){
    return items.filter(item => item.gender.includes(term));
    }
  }
}
