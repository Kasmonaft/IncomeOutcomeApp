package main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"services","configuration"})
public class ProjectRunner {

	public static void main(String[] args) {
		SpringApplication.run(ProjectRunner.class, args);
	}
	
}
