package com.estramipyme.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.estramipyme.api","com.estramipyme.data.repositories"})
public class InitialApplication {

	public static void main(String[] args) {
		SpringApplication.run(InitialApplication.class, args);
	}

}