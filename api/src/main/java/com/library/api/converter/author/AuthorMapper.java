package com.library.api.converter.author;

import com.library.api.dto.AuthorDTO;
import com.library.api.model.Author;
import fr.xebia.extras.selma.IgnoreMissing;
import fr.xebia.extras.selma.Mapper;

@Mapper(withIgnoreMissing = IgnoreMissing.ALL)
public interface AuthorMapper {

  AuthorDTO asAuthorDTO(Author author);
  Author asAuthor(AuthorDTO authorDTO);
}
