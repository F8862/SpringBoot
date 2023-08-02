package com.annotations.controller;

import com.annotations.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {

    @Autowired
    @Qualifier("student1")
    private Student student;

    @RequestMapping(value = "/house",method = RequestMethod.GET)
    @ResponseBody
    public Student house(@RequestBody Student st){
        st.studying();
        System.out.println("This is home method");
        this.student.setName("Furquan Ansari");
        return this.student;
    }

    @RequestMapping(value = "/user/{userId}",method = RequestMethod.GET)
    public String user(@PathVariable("userId") Integer userId){
        return String.valueOf(userId);

    }
}
