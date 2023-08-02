package com.debug.ctrl;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class MyController {
    @GetMapping("/about")
    public String getAbout(){
        String str="Subscribe to my channel";
       str=str.toLowerCase();
       str=str.toUpperCase();
        return  str;

    }
}
