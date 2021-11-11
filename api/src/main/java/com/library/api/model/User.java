package com.library.api.model;



import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class  User  {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String username;
  private String fristName;
  private String lastName;
  private LocalDate birthDay;
  private String email;
  private String tel;
  private String password;
  @ManyToMany(mappedBy = "users")
  private List<Role> roles;


  public void setUsername(String username) {
    this.username = username;
  }

  public String getUsername() {
    return username;
  }

  public String getFristNamae() {
    return fristName;
  }

  public void setFristNamae(String fristName) {
    this.fristName = fristName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public LocalDate getBirthDay() {
    return birthDay;
  }

  public void setBirthDay(LocalDate birthDay) {
    this.birthDay = birthDay;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getTel() {
    return tel;
  }

  public void setTel(String tel) {
    this.tel = tel;
  }

  public List<Role> getRoles() {
    return roles;
  }

  public void setRoles(List<Role> roles) {
    this.roles = roles;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getPassword() {
    return password;
  }
}
