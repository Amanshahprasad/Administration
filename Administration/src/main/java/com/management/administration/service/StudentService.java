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
        if(optional.isEmpty()){

        }
        return optional.get();
    }

    public Student getTheStudentDetailsByEmail(String email){
        Optional<Student> optional= studentRepository.findById(email);
        if(optional.isEmpty()){

        }

        return optional.get();
    }

    public String updateTheDetailsOfStudent(String email,String phoneNo){
        Optional<Student> optional= studentRepository.findById(email);
        if(!optional.isEmpty()){
            Student student= optional.get();
            student.setPhoneNo(phoneNo);
            studentRepository.saveAndFlush(student);
        }
        else{

        }

      return "phoneNo has been updated successfully";
    }

    public String deleteTheDetailsOfStudent(String firstName,String secondName){
        Optional<Student> optional= Optional.ofNullable(studentRepository.findByFirstNameAndLastName(firstName, secondName));
        if(!optional.isEmpty()){
            Student student= optional.get();
            studentRepository.deleteById(student.getEmail());
        }
        else {

        }
        return "details of student has been deleted";
    }
}
