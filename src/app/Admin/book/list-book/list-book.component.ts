import { Component, OnInit } from '@angular/core';
import { BookElement, BookService } from '../service/book.service';

@Component({
  selector: 'admin-list-book',
  templateUrl: './list-book.component.html',
  styleUrls: ['./list-book.component.css']
})
export class ListBookComponent implements OnInit {
  headers: String[] = ['code', 'title','author','description','price'];
  books:BookElement[];
  constructor(private bookService:BookService) { }

  ngOnInit(): void {
    this.books=this.bookService.getBooks();
  }
  deleteBook(code:string){
    this.bookService.delteBook(code);
  }


}
