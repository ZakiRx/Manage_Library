package com.library.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class AuthorDTO {
  private long id;
  @NotBlank
  @Length(min = 3,max=25)
  private String username;
  @NotBlank
  @Length(min = 3,max=25)
  private String firstName;
  @NotBlank
  @Length(min = 3,max=25)
  private String lastName;
  @NotBlank
  @Email
  private String email;
  @NotBlank
  private String password;
  @NotBlank
  private String confirmePassword;
  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }

  public String getConfirmePassword() {
    return confirmePassword;
  }

  public void setConfirmePassword(String confirmePassword) {
    this.confirmePassword = confirmePassword;
  }
}
