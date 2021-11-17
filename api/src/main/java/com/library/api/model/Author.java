package com.library.api.model;

import javax.persistence.*;
import java.util.List;

@Entity
//@DiscriminatorValue("zzzzz")
public class Author extends User {
  @OneToMany(mappedBy = "author")
  private List<Book> books;
  public List<Book> getBooks() {
    return books;
  }

  public void setBooks(List<Book> books) {
    this.books = books;
  }

}
