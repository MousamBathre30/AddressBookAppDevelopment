package com.spring.AddressbookAppDevelopment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class AddressbookAppDevelopmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(AddressbookAppDevelopmentApplication.class, args);
	}


	@GetMapping("/hello")
	public String sayhello(){
		return "hello from mousam";
	}

	
}
