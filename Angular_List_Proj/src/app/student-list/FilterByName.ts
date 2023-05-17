import {Pipe, PipeTransform} from "@angular/core";

@Pipe({
  name: 'FilterByName',
})
export class FilterByName implements PipeTransform {
  transform(items: any[], term: string): any {
    // I am unsure what id is here. did you mean title?
    return items.filter(item => item.name.includes(term));
  }
}
