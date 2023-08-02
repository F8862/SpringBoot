package com.annotations.controller;

import com.annotations.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
@Autowired
@Qualifier("student1")
    private Student student;

    @RequestMapping(value = "/home",method = RequestMethod.GET)
    @ResponseBody
    public String home(){
        System.out.println("This is home method");
       return "This is my name";
    }

    @RequestMapping(value = "/home1",method = RequestMethod.GET)
    @ResponseBody
    public Student home1(){
        System.out.println("This is home method");
        this.student.setName("Furquan Ansari");
        return this.student;
    }

    @RequestMapping(value = "/home2",method = RequestMethod.GET)
    @ResponseBody
    public Student home2(@RequestBody Student st){
        st.studying();
        System.out.println("This is home method");
        this.student.setName("Furquan Ansari");
        return this.student;
    }


}
