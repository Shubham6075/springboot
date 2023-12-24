package com.luv2code.springcoredemo.config;

import com.luv2code.springcoredemo.common.Coach;
import com.luv2code.springcoredemo.common.CricketCoach;
import com.luv2code.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {                // describing config bean

	@Bean("aquatic")
	public Coach swimCoach(){
		return new SwimCoach();
	}

	@Bean("bat")
	public Coach cricketCoach(){
		return new CricketCoach();
	}
}
