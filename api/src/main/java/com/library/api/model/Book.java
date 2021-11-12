package com.library.api.model;

import org.springframework.boot.context.properties.bind.DefaultValue;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Book {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  private Long id;
  @Column(unique = true)
  private String code;
  @Column(unique = true)
  private String title;
  private String description;
  private double price;
  private short numberOfPage;
  private boolean verifiedBook=false;
  @ManyToOne(cascade = CascadeType.REMOVE)
  private Author author;
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public short getNumberOfPage() {
    return numberOfPage;
  }

  public void setNumberOfPage(short numberOfPage) {
    this.numberOfPage = numberOfPage;
  }

  public boolean isVerifiedBook() {
    return verifiedBook;
  }

  public void setVerifiedBook(boolean verifiedBook) {
    this.verifiedBook = verifiedBook;
  }

  public Author getAuthor() {
    return author;
  }

  public void setAuthor(Author author) {
    this.author = author;
  }
}
