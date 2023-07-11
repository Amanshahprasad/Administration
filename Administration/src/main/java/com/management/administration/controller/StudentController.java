package com.management.administration.controller;

import com.management.administration.model.Student;
import com.management.administration.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200/")
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping()
    String enterTheStudentDetails(@RequestBody Student student){

        return studentService.addTheStudentDetails(student);
    }

    @GetMapping("fetchByEmail/{email}")
    Student fetchTheStudentByEmail(@PathVariable String email){

        return studentService.getTheStudentDetailsByEmail(email);
    }

    @GetMapping("fetchByName/{firstName}/{secondName}")
    Student fetchTheStudentByName(@PathVariable String firstName,@PathVariable String secondName){

        return studentService.getTheStudentDetailsByName(firstName,secondName);
    }

    @PutMapping("update/{email}/{phone}")
    String updateTheDetailsOfStudent(@PathVariable String email,@PathVariable String phone){

        return  studentService.updateTheDetailsOfStudent(email, phone);
    }

    @DeleteMapping("delete/{firstName}/{secondName}")
    String  removeTheDetailsOfStudent(@PathVariable String firstName,@PathVariable String secondName){

        return studentService.deleteTheDetailsOfStudent(firstName, secondName);
    }


}
