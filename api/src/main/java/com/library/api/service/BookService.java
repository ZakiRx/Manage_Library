package com.library.api.service;

import com.library.api.model.Author;
import com.library.api.model.Book;
import com.library.api.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
  private BookRepository bookRepository;
  public BookService(@Autowired BookRepository bookRepository){
    this.bookRepository=bookRepository;
  }

  public Book newBook(Book book){
   return bookRepository.save(book);
  }
  public Book editBook(Book book){
    return bookRepository.save(book);
  }
  public void deleteBook(Book book){
    bookRepository.delete(book);
  }
  public Optional<Book> getBookById(long id){
    return  bookRepository.findById(id);
  }
  public  Optional<Book> getBookByCode(String code){
   return bookRepository.findBookByCode(code);
  }
  public Optional<Book> getBookByTitle(String title){
    return  bookRepository.findBookByTitle(title);
  }
  public List<Book> getAllBooks(){
    return bookRepository.findAll();
  }
  public List<Book> getAllVerifiedBook(){
    return bookRepository.findBooksByVerifiedBookTrue();
  }
  public List<Book> getBooksByAuthor(Author author){
    return bookRepository.findBooksByAuthor(author);
  }
  public List<Book> getBooksBetweenPrice(double startPrice,double endPrice){
    return  bookRepository.findBooksByPriceBetween(startPrice,endPrice);
  }


 }
