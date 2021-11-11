package com.library.api.converter;

import com.library.api.dto.BookDto;
import com.library.api.model.Book;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class BookConverter{
  private ModelMapper modelMapper;
  public BookConverter(@Autowired ModelMapper modelMapper){
    this.modelMapper=modelMapper;
  }
  public Book dtoToEntity(BookDto bookDto){
    return modelMapper.map(bookDto,Book.class);
  }
  public  BookDto entityToDto(Book book){
    return modelMapper.map(book, BookDto.class);
  }
  public List<Book> dtoToEntity(List<BookDto> booksDto){
    return booksDto.stream().map(b->dtoToEntity(b)).collect(Collectors.toList());
  }
  public List<BookDto> entityToDto(List<Book> books){
    return books.stream().map(b->entityToDto(b)).collect(Collectors.toList());
  }
}
