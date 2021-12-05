package com.example.springdemo;

import com.example.model.School;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringDemoApplication.class, args);
    }

    @Bean(name="sysu")
    @ConditionalOnProperty(prefix = "demo.school", name = "name")
    @ConfigurationProperties(prefix="demo.school")
    public School createSchool() {
        return new School();
    }

    @Bean
    public HikariDataSource dataSource() {
        return new HikariDataSource();
    }


}
