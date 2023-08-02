package com.api.entity.controller;

import com.api.entity.Product;
import com.api.helper.Helper;
import com.api.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/product/upload")
    public ResponseEntity<?> upload(@RequestParam("file")MultipartFile file) throws InterruptedException {
        Thread.sleep(5000);
        if(Helper.checkExcelFormat(file)){
            this.productService.save(file);
            Map map=new HashMap<>();
            map.put("message","File is uploaded and data is saved to db sucessfully!!");
            return ResponseEntity.ok(map);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please upload excel file only");
    }

    @GetMapping("/product")
    public List<Product> getAllProducts(){
        return this.productService.getAllProducts();
    }
}
