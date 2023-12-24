package com.luv2code.springcoredemo.common;

// if we not use @Component to make container to scan this bean it will not run 
public class SwimCoach implements Coach{

	public SwimCoach(){
		System.out.println("In constructor : " + getClass().getSimpleName());
	}
	@Override
	public String getDailyWorkout() {
		return "Swim 1000 meters as a warmup";
	}
}
