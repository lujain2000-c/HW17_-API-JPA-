package com.example.hw17.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import jdk.jfr.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Check;
import org.hibernate.annotations.Checks;
import org.hibernate.annotations.Comment;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "should be not empty")
    @Size(min = 5, max = 20)
    @Column(columnDefinition = "varchar(20) not null")
    private String name;
    @NotEmpty(message = "should be not empty")
    @Size(min = 5, max = 20)
    @Column(columnDefinition = "varchar(20) unique not null")
    private String username;
    @NotEmpty(message = "should be not empty")
    @Column(columnDefinition = "varchar(8) not null")
    private String password;
    @NotEmpty(message = "should be not empty")
    @Email(message = "invalid email")
    @Column(columnDefinition = "varchar(50) not null")
    private String email;
    @NotEmpty(message = "should be not empty")
//    @Check(role == "admin" || role == "user")
//    @Checks({"admin", "user"})
    @Pattern(regexp = "(Admin|user)")
    @Column(columnDefinition = "varchar(20) not null check( role == 'user' || role = 'admin' )")
    private String role;
    @NotNull(message = "should be not empty")
    @Positive(message = "only numbers")
    @Column(columnDefinition = "int(20) not null")
    private Integer age;



}
