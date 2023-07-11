package com.management.administration.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Student {
    @Id
    String username;
    String password;
    String email;
    String firstName;
    String lastName;
    String phone;

}
