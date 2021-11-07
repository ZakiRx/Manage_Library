import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'pow'
})
export class PowPipe implements PipeTransform {

  transform(value: number,pow:number=1): unknown {
    return Math.pow(value,pow);
  }

}
