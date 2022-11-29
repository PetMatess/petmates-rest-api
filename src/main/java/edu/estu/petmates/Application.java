package edu.estu.petmates;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	/*@Bean
	CommandLineRunner createInitialUsers(UserService userService){
		return (args) -> {
			 User user = new User();
			 user.setUsername("user1");
			 user.setPassword("P4ssword");
			 userService.save(user);
		};*/
}

