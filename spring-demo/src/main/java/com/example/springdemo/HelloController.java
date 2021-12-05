package com.example.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
public class HelloController {

    @Autowired
    private HelloServiceImpl helloService;

    @GetMapping("/")
    public String index() {
        return "Greetings from Spring Boot!" + helloService.getSchoolName();
    }

    @GetMapping("/jdbc/addStudent")
    public String addStudent() {
        return "Greetings from Spring Boot!" + helloService.addStudent();
    }

    @GetMapping("/jdbc/deleteStudent")
    public String deleteStudent() throws SQLException {
        return "Greetings from Spring Boot!" + helloService.deleteStudent();
    }

}
