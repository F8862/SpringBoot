package com.practice.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyController {
	
	@RequestMapping(value = "/about",method = RequestMethod.GET)
	public String about(Model model) {
		System.out.println("Inside about handler...");
		//putting data in model
		model.addAttribute("name","Furquan Ansari");
		model.addAttribute("CurrentDate",new Date().toLocaleString());
		return "about";
		
	}
	
	//handling iteration
	@GetMapping("/example-loop")
	public String iterateHandler(Model m) {
		//create a list
	    List<String> names=new ArrayList<String>();
	    names.add("Ankit");
	    names.add("Laxmi");
	    names.add("Karan");
	    names.add("John");
	    m.addAttribute("names",names);
		return "iterate";
		
	}
	
	//handler for conditional statement
	@GetMapping("/condition")
	public String conditionHandler(Model m) {
		System.out.println("Conditional handler executed........");
		m.addAttribute("isActive",false);
		m.addAttribute("gender","F");
		List<Integer> nums=new ArrayList<Integer>();
		nums.add(121);
		nums.add(222);
		nums.add(323);
		nums.add(424);
		m.addAttribute("myList",nums);
		return "condition";
		
	}
	
	//handler for including fragment
	@GetMapping("/service")
	public String serviceshandler(Model m) {
		m.addAttribute("title","I like Java");
		m.addAttribute("subTitle",LocalDateTime.now().toString());
		return "service";
		
	}
	
	//for new about
	@GetMapping("/newAbout")
	public String newAbout() {
		return "aboutnew";
		
	}
	
	@GetMapping("/contact")
	public String contact() {
		return "contact";
		
	}

}
