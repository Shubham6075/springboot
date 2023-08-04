package com.example.SpringBootCRUD;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloWorldController {

	@GetMapping("/hello")
	public String hello() {
		return "hello"; // Assuming there is a template named "hello.html" in the "resources/templates" folder
	}
}