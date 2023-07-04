package com.sogyo.rvgelder.ipdebitcardreplacementflow;

import com.sogyo.rvgelder.ipdebitcardreplacementflow.entity.AuthorizationLevel;
import com.sogyo.rvgelder.ipdebitcardreplacementflow.entity.CardArrangement;
import com.sogyo.rvgelder.ipdebitcardreplacementflow.entity.Customer;
import com.sogyo.rvgelder.ipdebitcardreplacementflow.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
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
