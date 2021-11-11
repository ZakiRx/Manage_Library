package com.library.api.repository;

import com.library.api.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface AuthorRepository extends JpaRepository<Author,Long> {
  Optional<Author> findByUsername(String usrname);
}
