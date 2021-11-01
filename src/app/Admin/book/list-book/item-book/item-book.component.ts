import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { BookElement, BookService } from '../../service/book.service';

@Component({
  selector: 'app-item-book',
  templateUrl: './item-book.component.html',
  styleUrls: ['./item-book.component.css']
})
export class ItemBookComponent implements OnInit {

  codeBook:string;
  book:BookElement;
  constructor(private bookService:BookService,private activedRoute:ActivatedRoute ) { }

  ngOnInit(): void {
    this.activedRoute.paramMap.subscribe(params=>{
      this.codeBook=params.get('id');
    });
    if(this.codeBook!=null){
      this.book=this.bookService.getBookByCode(this.codeBook);
    }
  }

}
