package com.management.administration.repository;

import com.management.administration.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student,String> {

    Student findByFirstNameAndLastName(String firstName,String lastName);
    Student findByUsernameAndPassword(String username,String password);
}
