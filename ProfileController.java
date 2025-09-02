package com.zidio.student_module;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profiles")
public class ProfileController {

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("/save")
    public String saveProfile(@RequestBody Student student) {
        if (student.getFullName() == null || student.getFullName().isEmpty()) {
            throw new IllegalArgumentException("Full name cannot be null or empty");
        }
        studentRepository.save(student);
        return "Profile saved successfully!";
    }
}
