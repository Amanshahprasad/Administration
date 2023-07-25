package com.management.administration.controller;

import com.management.administration.model.Student;
import com.management.administration.model.UpdateUser;
import com.management.administration.repository.StudentRepository;
import com.management.administration.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200/")
public class StudentController {
    @Autowired
    StudentService studentService;
    @Autowired
    StudentRepository studentRepository;

    @PostMapping("/create")
    String enterTheStudentDetails(@RequestBody Student student){

        return studentService.addTheStudentDetails(student);
    }

    @GetMapping("/fetchStudent/{username}/{password}")
    Student fetchTheStudentByEmail(@PathVariable String username,@PathVariable String password){

        return studentService.getTheStudentDetails(username,password);
    }


    @PutMapping("/update/")
    String updateTheDetailsOfStudent(@RequestBody UpdateUser updateUser){

        return  studentService.updateTheDetailsOfStudent(updateUser);
    }

    @DeleteMapping("delete/{username}")
    void  removeTheDetailsOfStudent(@PathVariable String username){

         studentRepository.deleteById(username);
    }



}
