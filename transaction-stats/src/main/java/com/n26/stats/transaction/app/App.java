package com.n26.stats.transaction.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan("com.n26.stats")
public class App extends SpringBootServletInitializer{

	public static void main(String[] args) throws Exception {
		SpringApplication.run(App.class, args);
	}
	
}