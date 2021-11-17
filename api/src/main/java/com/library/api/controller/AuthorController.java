package com.library.api.controller;

import com.library.api.converter.author.AuthorConverter;
import com.library.api.dto.AuthorDTO;
import com.library.api.model.Author;
import com.library.api.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
  @PostMapping("/new")
  public ResponseEntity<String>  newAuthor(@Valid @RequestBody AuthorDTO authorDTO){
    if(authorDTO.getPassword().equals(authorDTO.getConfirmePassword())){
      Author author=authorConverter.dtoToEntity(authorDTO);
      authorService.newAuthor(author);
      return  new ResponseEntity<>("Author add",HttpStatus.CREATED);
    }
    return ResponseEntity.badRequest().body("password not match");
  }

  @PutMapping("/edit/{id}")
  public ResponseEntity<String> editAuthor(@PathVariable int id,@RequestBody AuthorDTO authorDTO) {
    Author author = authorService.getAuthorById(id).get();
    author.setFirstName(authorDTO.getFirstName());
    author.setLastName(authorDTO.getLastName());
    author.setEmail(authorDTO.getEmail());
    authorService.editAuthor(author);
    return  new ResponseEntity<>("Author edited",HttpStatus.ACCEPTED);

  }
}
