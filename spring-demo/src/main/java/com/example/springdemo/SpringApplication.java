package com.example.springdemo;

import com.example.model.Klass;
import com.example.model.School;
import com.example.model.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringApplication {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student freshStudent1 = (Student) applicationContext.getBean("freshStudent1");
        Klass klass = (Klass) applicationContext.getBean("class");
        School school = (School) applicationContext.getBean("school");
    }
}
