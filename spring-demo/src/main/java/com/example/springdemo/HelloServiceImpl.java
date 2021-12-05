package com.example.springdemo;

import com.example.model.School;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@Service
public class HelloServiceImpl {
    @Autowired
    private School school;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private HikariDataSource dataSource;

    public String getSchoolName() {
        return school.getName();
    }

    public String addStudent() {
        //插入语句，注意时间问题
        String sql = "insert into student(id, name, score) values (1,'wangwu',650)";
        jdbcTemplate.update(sql);
        //查询
        return "添加用户成功";
    }

    public String deleteStudent() throws SQLException {
        Connection connection = dataSource.getConnection();
        Statement statement = connection.createStatement();
        statement.addBatch("insert into student(id, name, score) values (1,'wangwu',650)");
        statement.executeBatch();
        statement.close();
        connection.close();
        //查询
        return "批量添加用户成功";
    }

}
