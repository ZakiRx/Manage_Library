import { Component, OnInit,EventEmitter, Output, Input } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { BookElement, BookService } from '../../service/book.service';
@Component({
  selector: 'app-form-book',
  templateUrl: './form-book.component.html',
  styleUrls: ['./form-book.component.css']
})
export class FormBookComponent implements OnInit {
  codeBook:string;
  bookForm;
  bookData:BookElement;
  constructor( private formBuilder: FormBuilder,private bookService:BookService,private router:Router,private activeRoute:ActivatedRoute) { 

  }
  ngOnInit(): void {
      this.activeRoute.paramMap.subscribe(params=>{
      this.codeBook =params.get('id');
      this.bookData={
        code:'',
        title: '',
        author: '',
        description:'',
        price:0
      }
      if(this.codeBook!=null){
        this.bookData=this.bookService.getBookByCode(this.codeBook);
      }
      this.bookForm= this.formBuilder.group(this.bookData);

    })
  }
  // @Input() books; //get books table from parent component
  // @Output() bookCreated = new EventEmitter<{code:string,title: string ,description:string,author:string,price:number}>(); //send new data to parent component
  onSubmit(): void {
    console.log(this.bookForm.value);
 
     if(this.codeBook==null){
      let numberItemInArray=this.bookService.getBooks()==null?0:this.bookService.getBooks().length;
      let partOfNameAuthor=this.bookForm.value.author.slice(0,3);
      this.bookForm.value.code=partOfNameAuthor+"-"+(numberItemInArray+1);
      this.bookService.newBook(this.bookForm.value);
     }
     else{
       this.bookService.editBook(this.bookForm.value);
     }
    // this.bookCreated.emit(this.bookForm.value); // send data to function  located in  component parent , in  this example function is onBookAdded() 
    this.bookForm.reset();
    this.returnToListBooks();  
  }
  
  returnToListBooks(){
    this.router.navigate(['/admin/book'], { replaceUrl: true });
  }



}
