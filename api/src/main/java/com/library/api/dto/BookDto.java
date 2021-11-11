package com.library.api.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class BookDto {
  private long id;
  @NotBlank
  @NotNull
  private String title;
  private String code;
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

  public String getAuthorUsername() {
    return authorUsername;
  }

  public void setAuthorUsername(String authorUsername) {
    this.authorUsername = authorUsername;
  }
}
