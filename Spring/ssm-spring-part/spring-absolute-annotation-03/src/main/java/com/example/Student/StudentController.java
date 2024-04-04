package com.example.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class StudentController {
    @Autowired(required = false)
    @Qualifier(value="StudentService")
    private StudentService service;

}
