import { Injectable } from '@angular/core';

export interface BookElement {
  id:number;
  code: string;
  title: string;
  description: string;
  price: number;
  numberOfPage:string;
  verified:boolean;
  createdAt:Date;
  updatedAt:Date;
  author: string;
}
@Injectable({
  providedIn: 'root'
})
export class BookService {
  constructor() { }
  books: BookElement[] = JSON.parse(localStorage.getItem('books'));

  getBooks():BookElement[]{
    return this.books;
  }
  newBook(data:BookElement):void{
     this.books.push(data);
     this.saveBooksInLocalStorage();
  }
  getBookByCode(code:string):BookElement{
    let book=this.books.find(b=>{return b.code==code});
    return book;
  }
  editBook(newBook:BookElement):void{
    let book=this.books.find(b=>{return b.code==newBook.code});
    book.author=newBook.author;
    book.description=newBook.description;
    book.title=newBook.title;
    book.price=newBook.price;
    this.saveBooksInLocalStorage();
  }
  delteBook(code:string){
    this.books.forEach((b,index)=> {
      if(b.code==code)
        this.books.splice(index,1);
    });
    this.saveBooksInLocalStorage();

  }

  saveBooksInLocalStorage(){
    localStorage.setItem('books',JSON.stringify(this.books));
  }
}
