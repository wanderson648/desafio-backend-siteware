package com.wo.siteware.desafio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DesafioApplication {

    @GetMapping
    public String test() {
        return "Test";
    }

	public static void main(String[] args) {
        SpringApplication.run(DesafioApplication.class, args);
	}

}
