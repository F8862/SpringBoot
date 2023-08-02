package com.annotations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import java.util.Date;

@Configuration
@ComponentScan(basePackages = {"myPack"})
public class MyConfig {
    @Bean("student1")
    @Lazy
    public Student getStudent(){
        System.out.println("creating first student class object");
        return new Student("Student1");
    }

    @Bean("student2")
    @Lazy
    public Student createStudent(){
        System.out.println("creating second student class object");
        return new Student("Student2");
    }

    @Bean
    public Date getDate(){
        System.out.println("Creating new date");
        return  new Date();
    }

}
