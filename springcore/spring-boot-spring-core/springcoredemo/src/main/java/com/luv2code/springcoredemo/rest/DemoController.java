package com.luv2code.springcoredemo.rest;

import com.luv2code.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	// define private field for the dependency
	private Coach myCoach;
	// private Coach anotherCoach;

	// define a constructor for dependency injection - constructor injection
	@Autowired
  // here we are using @Qualifier annotation to specify which class need to print

	public DemoController(@Qualifier("bat")Coach theCoach){
	                     // @Qualifier("cricketCoach")Coach theAnotherCoach){
		System.out.println("In constructor : " +getClass().getSimpleName());
       myCoach = theCoach;
	  //  anotherCoach = theAnotherCoach;
	}

//	@Autowired
	// this we used when we are  using   @Primary annotation on a specific class
//	public DemoController(Coach theCoach){
//		myCoach = theCoach;
//	}

	// using setter injection
//	@Autowired
//	public void setCoach(Coach theCoach){
//		myCoach = theCoach;
//	}

	@GetMapping("/dailyworkout")
	public String getDailyWorkout(){
		return myCoach.getDailyWorkout();
	}

//	@GetMapping("/check")
//	public String check(){
//		// give true because by default it is singleton
//
//		//if we use this on bean we are performing operation
//		// @Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)  will give false
//		return "Comparing beans : myCoach == anotherCoach, " +(myCoach == anotherCoach);
//	}

}
