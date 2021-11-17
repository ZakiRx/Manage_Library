package com.library.api.dto;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class BookDto {
  private long id;
  @NotBlank
  @NotNull
  @Size(min=3,max = 25)
  private String title;
  @NotBlank
  private String code;
  @NotBlank
  @Length(min=10,max = 500)
  private String description;
  @NotNull
  @Min(0)@Max(5000)
  private double price;
  @NotNull
  @Min(0)
  private short numberOfPage;
  private boolean verified;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
  private long userId;
  private String authorUsername;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public long getUserId() {
    return userId;
  }

  public void setUserId(long userId) {
    this.userId = userId;
  }

  public String getAuthorUsername() {
    return authorUsername;
  }

  public void setAuthorUsername(String authorUsername) {
    this.authorUsername = authorUsername;
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

  public boolean getVerified() {
    return verified;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public void setUpdatedAt(LocalDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }
  public LocalDateTime getUpdatedAt() {
    return updatedAt;
  }

}
