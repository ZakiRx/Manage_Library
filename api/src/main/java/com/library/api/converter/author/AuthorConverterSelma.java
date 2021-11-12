package com.library.api.converter.author;

import com.library.api.converter.ConverterService;
import com.library.api.converter.book.BookMapper;
import com.library.api.dto.AuthorDTO;
import com.library.api.dto.BookDto;
import com.library.api.model.Author;
import com.library.api.model.Book;
import fr.xebia.extras.selma.Selma;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorConverterSelma implements AuthorConverter {
  private final AuthorMapper authorMapper= Selma.builder(AuthorMapper.class).build();

  public Author dtoToEntity(AuthorDTO authorDTO){
    return authorMapper.asAuthor(authorDTO);
  }
  public  AuthorDTO entityToDto(Author author){
    return authorMapper.asAuthorDTO(author);
  }
  public List<Author> dtoToEntity(List<AuthorDTO> authorsDto){
    return authorsDto.stream().map(a->dtoToEntity(a)).collect(Collectors.toList());
  }
  public List<AuthorDTO> entityToDto(List<Author> authors){
    return authors.stream().map(a->entityToDto(a)).collect(Collectors.toList());
  }
}
