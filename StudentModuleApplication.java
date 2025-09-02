package com.zidio.student_module;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.zidio.student_module")
public class StudentModuleApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentModuleApplication.class, args);
        System.out.println("Student Module Application Started Successfully!");
    }
}
