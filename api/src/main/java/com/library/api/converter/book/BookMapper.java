package com.library.api.converter.book;

import com.library.api.dto.BookDto;
import com.library.api.model.Book;
import fr.xebia.extras.selma.Field;
import fr.xebia.extras.selma.IgnoreMissing;
import fr.xebia.extras.selma.Mapper;
@Mapper(withIgnoreMissing = IgnoreMissing.ALL,withCustomFields = {@Field({"author.id","userId"}),@Field({"author.username","authorUsername"})})
public interface BookMapper {
  BookDto asBookDTO(Book book);
  Book asBook(BookDto bookDto);
}
