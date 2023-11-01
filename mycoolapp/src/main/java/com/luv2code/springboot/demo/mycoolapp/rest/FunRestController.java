package com.luv2code.springboot.demo.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

	// inject properties for : coach.name , team.name

	@Value("${coach.name}")
	private String coachName;

	@Value("${team.name}")
	private String teamName;

	// expose new endpoints for "teamInfo"

	@GetMapping("/teaminfo")
	public String getTeamInfo(){
		return "Coach : "+coachName +", Team Name : "+teamName;
	}

	// expose "/" that return "Hello World"

	@GetMapping("/")
	public String sayHello(){
		return "Hello World !";
	}

	@GetMapping("/workout")
	public String getDailyWorkOut(){
		return "Run a Hard 5k! ";
	}

	@GetMapping("/fortune")
	public String getDailyFortune(){
		return "Today is your luck day.";
	}
}
