package com.luv2code.springcoredemo.common;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
 // @Lazy  - it is used so that bean is not initialized
//@Primary      // declared track coach as primary bean ( will give output Run a hard 5k)
//              // as we use this annotation so, we don't need to use @Qualifier now
//              // can't use multiple primary annotation bcz it will giv error due to
//              // multiple primary classes found
public class TrackCoach implements Coach{

	public TrackCoach(){
		System.out.println("In constructor : " +getClass().getSimpleName());
	}
	@Override
	public String getDailyWorkout() {
		return "Run a hard 5k !";
	}
}
