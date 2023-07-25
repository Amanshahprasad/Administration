package com.management.administration.service;

import com.management.administration.model.Student;
import com.management.administration.model.UpdateUser;
import com.management.administration.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public String addTheStudentDetails(Student student){
        studentRepository.saveAndFlush(student);
     return "student details saved successfully";
    }

    public Student getTheStudentDetailsByName(String firstName,String secondName){
        Optional<Student> optional= Optional.ofNullable(studentRepository.findByFirstNameAndLastName(firstName, secondName));

        return optional.get();
    }

    public Student getTheStudentDetails(String username,String password){
        Optional<Student> optional= Optional.ofNullable(studentRepository.findByUsernameAndPassword(username, password));
        return optional.get();
    }

    public String updateTheDetailsOfStudent(UpdateUser updateUser){

        Optional<Student> optional= studentRepository.findById(updateUser.getUsername());

            Student student= optional.get();
            student.setPhone(updateUser.getPhone());
            studentRepository.saveAndFlush(student);


      return "phone has been updated successfully";
    }

    public void deleteTheDetailsOfStudent(String email){
        //Optional<Student> optional= Optional.ofNullable(studentRepository.findByFirstNameAndLastName(email));


            studentRepository.deleteById(email);


    }
}
