package com.library.api.repository;

import com.library.api.model.Author;
import com.library.api.model.Book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book,Long> {

  Optional<Book> findBookByCode(String code);

  Optional<Book> findBookByTitle(String title);
  List<Book> findBooksByVerifiedTrue();
  List<Book> findBooksByAuthor(Author author);
  List<Book> findBooksByPriceBetween(double startPrice,double endPrice);
}
