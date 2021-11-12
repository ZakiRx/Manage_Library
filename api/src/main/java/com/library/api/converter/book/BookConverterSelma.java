package com.library.api.converter.book;

import com.library.api.converter.ConverterService;
import com.library.api.dto.BookDto;
import com.library.api.model.Book;
import fr.xebia.extras.selma.Selma;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service("bookConverter")
public class BookConverterSelma implements BookConverter {
  private final BookMapper bookMapper= Selma.builder(BookMapper.class).build();

  public Book dtoToEntity(BookDto bookDto){
    return bookMapper.asBook(bookDto);
  }
  public  BookDto entityToDto(Book book){
    return bookMapper.asBookDTO(book);
  }
  public List<Book> dtoToEntity(List<BookDto> booksDto){
    return booksDto.stream().map(b->dtoToEntity(b)).collect(Collectors.toList());
  }
  public List<BookDto> entityToDto(List<Book> books){
    return books.stream().map(b->entityToDto(b)).collect(Collectors.toList());
  }
}
