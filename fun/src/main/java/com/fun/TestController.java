package com.fun;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @RequestMapping("/test")
    public ResponseEntity<?> getUser(){
        Map<String,Object> user=new HashMap<>();
        user.put("name", "Ansari");
        user.put("city", "akola");
        return ResponseEntity.ok(user);
}
    
}
