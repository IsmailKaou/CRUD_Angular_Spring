import {Pipe, PipeTransform} from "@angular/core";

@Pipe({
  name: 'FilterByStatus',
})
export class FilterByStatus implements PipeTransform {
  transform(items: any[], term: string): any {
    return items.filter(item => term==="valid" ? item.mark >12 : term=="ratt" ? item.mark >=10 && item.mark<12 : term==="exclu" ? item.mark <10 : items );
  }
}
