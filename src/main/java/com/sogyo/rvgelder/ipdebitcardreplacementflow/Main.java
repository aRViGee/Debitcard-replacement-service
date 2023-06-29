package com.sogyo.rvgelder.ipdebitcardreplacementflow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

//	@Bean
//	CommandLineRunner commandLineRunner(CustomerRepository repository) {
//		return args -> {
////			add some data
//			repository.save(new Customer.CustomerTest(null, AuthorizationLevel.LEVEL_1, null));
//		};
//	}

}
