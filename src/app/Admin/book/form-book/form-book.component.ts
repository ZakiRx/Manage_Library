import { Component, OnInit,EventEmitter, Output, Input } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { BookElement, BookService } from '../service/book.service';
@Component({
  selector: 'app-form-book',
  templateUrl: './form-book.component.html',
  styleUrls: ['./form-book.component.css']
})
export class FormBookComponent implements OnInit {
  codeBook:string;
  bookForm:FormGroup;
  bookData={
    code:new FormControl(''),
    title: new FormControl('',[Validators.minLength(4),Validators.required]),
    author: new FormControl('',[Validators.minLength(3),Validators.required]),
    description:new FormControl('',[Validators.required]),
    price:new FormControl(0,[Validators.min(1),Validators.required]),
  };
  constructor( private formBuilder: FormBuilder,private bookService:BookService,private router:Router,private activeRoute:ActivatedRoute) { 
  }
  ngOnInit(): void {
    console.log("load child ");
      this.activeRoute.paramMap.subscribe(params=>{
      this.codeBook =params.get('id');
      if(this.codeBook!=null){
        let book=this.bookService.getBookByCode(this.codeBook);
        this.bookData={
          code:new FormControl(book.code),
          title: new FormControl(book.title,[Validators.minLength(4),Validators.required]),
          author: new FormControl(book.author,[Validators.minLength(3),Validators.required]),
          description:new FormControl(book.description,[Validators.required]),
          price:new FormControl(book.price,[Validators.min(1),Validators.required]),
        }
      }
      this.bookForm= new FormGroup(this.bookData);

    })
  }
  // @Input() books; //get books table from parent component
  // @Output() bookCreated = new EventEmitter<{code:string,title: string ,description:string,author:string,price:number}>(); //send new data to parent component
  onSubmit(): void { 
    
    if(this.bookForm.valid){
      if(this.codeBook==null ){
        let numberItemInArray=this.bookService.getBooks()==null?0:this.bookService.getBooks().length;
        let partOfNameAuthor=this.bookForm.value.author.slice(0,3);
        this.bookForm.value.code=partOfNameAuthor+"-"+(numberItemInArray+1);
        this.bookService.newBook(this.bookForm.value);
       }
       else{
         this.bookService.editBook(this.bookForm.value);
       }
       this.bookForm.reset();
       this.returnToListBooks();
    }
     
    // this.bookCreated.emit(this.bookForm.value); // send data to function  located in  component parent , in  this example function is onBookAdded() 
     
  }
  
  returnToListBooks(){
    this.router.navigate(['/admin/book']);
  }



}
