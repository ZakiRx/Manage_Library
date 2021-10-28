import { Component, Input, OnInit } from '@angular/core';
import { BookElement, BookService } from '../service/book.service';


@Component({
  selector: 'app-book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.css'],
})
export class BookComponent implements OnInit {
  headers: String[] = ['code', 'title','author','description','price'];
  books:BookElement[];
  constructor(private bookService:BookService) {}

  ngOnInit(): void {
    this.books=this.bookService.getBooks();
  }
  deleteBook(code:string){
  
    this.bookService.delteBook(code);
    
  }
  // onBookAdded(eventData: { code:string,title: string ,description:string,author:string,price:number}) {
  //   this.bookService.newBook(eventData)
  // }
}
