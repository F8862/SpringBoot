package com.learn.cntroller;

import com.learn.helper.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HomeController {
    @Autowired
    private Student student;

    @GetMapping("/get-data")
    public Map<String,String> getData(){
Map<String,String> map=new HashMap();
map.put("Name","Furquan Ansari");
        return map;
    }
}
