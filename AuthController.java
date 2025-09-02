package com.zidio.student_module.controller;

import com.zidio.student_module.entity.Student;
import com.zidio.student_module.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private StudentRepository studentRepository;

 
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Student student) {
        if (student.getFullName() == null || student.getFullName().isEmpty()) {
            return ResponseEntity.badRequest().body("Full name cannot be empty");
        }
        if (student.getEmail() == null || student.getEmail().isEmpty()) {
            return ResponseEntity.badRequest().body("Email cannot be empty");
        }
        if (student.getPassword() == null || student.getPassword().isEmpty()) {
            return ResponseEntity.badRequest().body("Password cannot be empty");
        }

        studentRepository.save(student);
        return ResponseEntity.ok("Registration successful");
    }

   
    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody Student student) {
        // Find student by email
        Student existingStudent = studentRepository.findByEmail(student.getEmail());

        if (existingStudent != null && existingStudent.getPassword().equals(student.getPassword())) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(401).body("Invalid email or password");
        }
    }
}
