package com.library.api.controller;
import com.library.api.converter.book.BookConverter;
import com.library.api.dto.BookDto;
import com.library.api.model.Book;
import com.library.api.service.AuthorService;
import com.library.api.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
  @Autowired
  private BookService bookService;
  @Autowired
  private AuthorService authorService;
  @Autowired
  @Qualifier("bookConverter")
  private BookConverter bookConverter;
  @GetMapping("/")
  public List<BookDto> showBooks(){
    return bookConverter.entityToDto(bookService.getAllBooks());
  }
  @GetMapping("/{id}")
  public ResponseEntity<?> showBooks(@PathVariable("id") long id){
    try{
      return  new ResponseEntity<>(bookConverter.entityToDto(bookService.getBookById(id).get()), HttpStatus.CREATED);
    }catch(Exception ex){
      return new ResponseEntity<>("Book Not Found",HttpStatus.NOT_FOUND);
    }
  }

  @PostMapping("/new")
  public ResponseEntity<String> newBook(@Valid @RequestBody BookDto bookDto){
    Book book =  bookConverter.dtoToEntity(bookDto);
    bookService.newBook(book);
    return new ResponseEntity<>("book added",HttpStatus.CREATED);
  }


}
