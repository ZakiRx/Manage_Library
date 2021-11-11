package com.library.api.controller;
import com.library.api.converter.BookConverter;
import com.library.api.dto.BookDto;
import com.library.api.model.Author;
import com.library.api.model.Book;
import com.library.api.service.AuthorService;
import com.library.api.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
  @Autowired
  private BookService bookService;
  @Autowired
  private AuthorService authorService;
  @Autowired
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

  public ResponseEntity<String> newBook(@RequestBody )


}
