package com.library.api.converter.author;

import com.library.api.dto.AuthorDTO;
import com.library.api.model.Author;
import fr.xebia.extras.selma.Field;
import fr.xebia.extras.selma.IgnoreMissing;
import fr.xebia.extras.selma.Mapper;
import fr.xebia.extras.selma.Maps;

@Mapper(withIgnoreMissing = IgnoreMissing.ALL,withIgnoreFields = {"confirmePassword"})
public interface AuthorMapper {
  AuthorDTO asAuthorDTO(Author author);
  Author asAuthor(AuthorDTO authorDTO);
}
