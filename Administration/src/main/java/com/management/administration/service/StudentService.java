package com.management.administration.service;

import com.management.administration.model.Student;
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

    public Student getTheStudentDetailsByEmail(String email){
        Optional<Student> optional= studentRepository.findById(email);

        return optional.get();
    }

    public String updateTheDetailsOfStudent(String email,String phone){
        Optional<Student> optional= studentRepository.findById(email);

            Student student= optional.get();
            student.setPhone(phone);
            studentRepository.saveAndFlush(student);


      return "phone has been updated successfully";
    }

    public String deleteTheDetailsOfStudent(String firstName,String secondName){
        Optional<Student> optional= Optional.ofNullable(studentRepository.findByFirstNameAndLastName(firstName, secondName));

            Student student= optional.get();
            studentRepository.deleteById(student.getEmail());

        return "details of student has been deleted";
    }
}
