package com.example.thymeleaf.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloWorldController {

	// need a controller method to show initial html form
	@GetMapping("/showForm")
	public String showForm(){
		return "helloworld-form";
	}

	// need a controller method to process the html form
	@RequestMapping("/processForm")
	public String processForm(){
		return "helloworld";
	}

	// need a controller method to read form data

	// and add data to the model
	@RequestMapping("/processFormVersionTwo")
	public String letsShoutDude(HttpServletRequest request, Model model){

		// read the request parameter from html form
		String theName = request.getParameter("studentName");

		// convert data to all caps
		theName = theName.toUpperCase();

		// create the message
		String result = "Yo ! " + theName;

		// add message to model
		model.addAttribute("message",result);

		return "helloWorld";
	}

	@PostMapping("/processFormVersionThree")
	public String processFormVersionThree(@RequestParam("studentName") String theName, Model model){

		// convert data to all caps
		theName = theName.toUpperCase();

		// create the message
		String result = "Hey Buddy ! " + theName;

		// add message to model
		model.addAttribute("message",result);

		return "helloWorld";
	}
}

