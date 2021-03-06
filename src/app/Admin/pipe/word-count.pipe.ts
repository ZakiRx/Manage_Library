import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'wordCount'
})
export class WordCountPipePipe implements PipeTransform {

  transform(value: string): number {
    return value.length;
  }

}
