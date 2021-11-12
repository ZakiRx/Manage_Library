package com.library.api.service;

import com.library.api.model.Author;
import com.library.api.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {

  private AuthorRepository authorRepository;
  public  AuthorService(@Autowired AuthorRepository authorRepository){
    this.authorRepository=authorRepository;
  }
  public Author newAuthor(Author author){
    return this.authorRepository.save(author);
  }
  public  Author editAuthor(Author author){
    return  this.authorRepository.save(author);
  }
  public void deleteAuthor(Author author){
    this.authorRepository.delete(author);
  }
  public List<Author> getAllAuthor(){
    return  authorRepository.findAll();
  }
  public Optional<Author> getAuthorByUsername(String username){
    return authorRepository.findByUsername(username);
  }

}
