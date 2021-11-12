package com.library.api.controller;

import com.library.api.converter.author.AuthorConverter;
import com.library.api.dto.AuthorDTO;
import com.library.api.model.Author;
import com.library.api.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {
  @Autowired
  private AuthorConverter authorConverter;
  @Autowired
  private AuthorService authorService;
  @Autowired
  @GetMapping("/")
  public ResponseEntity<?> getAuthors(){
    return new ResponseEntity<>(authorConverter.entityToDto(authorService.getAllAuthor()), HttpStatus.OK);
  }
  @GetMapping("/{username}")
  public ResponseEntity<?> getAuthor(@PathVariable String username){
    return  new ResponseEntity<>(authorConverter.entityToDto(authorService.getAuthorByUsername(username).get()),HttpStatus.OK);
  }
}
