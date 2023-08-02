package com.postgres.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class Studentdao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    //create the table
    public void createtable(){
        String query="CREATE TABLE student(id SERIAL PRIMARY KEY,name varchar(255) Not NULL,city varchar(255))";
       int update= this.jdbcTemplate.update(query);
        System.out.println(update);
    }
    //inserting data into db
    public  void  inserData(String name,String city){
        String q="insert into student(name,city) values(?,?)";
        int update=this.jdbcTemplate.update(q,name,city);
        System.out.println(update +"rows added");
    }
}
