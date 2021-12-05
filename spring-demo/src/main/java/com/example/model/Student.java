package com.example.model;

import lombok.Data;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Data
public class Student {

    private Klass klass;

    private String id;

    private String name;

    private Integer score;
}
