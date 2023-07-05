package com.sogyo.rvgelder.ipdebitcardreplacementflow;

import com.sogyo.rvgelder.ipdebitcardreplacementflow.entity.*;
import com.sogyo.rvgelder.ipdebitcardreplacementflow.repository.CardArrangementRepository;
import com.sogyo.rvgelder.ipdebitcardreplacementflow.repository.CardRepository;
import com.sogyo.rvgelder.ipdebitcardreplacementflow.repository.CustomerRepository;
import com.sogyo.rvgelder.ipdebitcardreplacementflow.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.PrintStream;
import java.util.Date;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {


		SpringApplication.run(Main.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(
			CustomerRepository customerRepository,
			CardArrangementRepository cardArrangementRepository,
			CardRepository cardRepository) {
		return args -> {
//			add some data
			Customer customer1 = customerRepository.save(new Customer(AuthorizationLevel.LEVEL_2));
			Customer customer2 = customerRepository.save(new Customer(AuthorizationLevel.LEVEL_3));
			customer1.cardArrangements.add(new CardArrangement(customer1));
			customer1.cardArrangements.add(new CardArrangement(customer1));
			customer2.cardArrangements.add(new CardArrangement(customer2));//
			System.out.println("Customer"+ customer1.getId() +" - Amount of cardArrangements in domain: " + customer1.getCardArrangements().size());
			System.out.println("Customer"+ customer2.getId() +" - Amount of cardArrangements in domain: " + customer2.getCardArrangements().size());
			System.out.println("Amount of cardArrangements in DB: " + cardArrangementRepository.findAll().size());

			customer1.getCardArrangements().get(0).getCards().add(new Card(Status.ACTIVE));
			System.out.println("Customer1 - Amount of cards in domain: " + customer1.getCardArrangements().get(0).getCards().size());
			System.out.println("Amount of cards in DB: " + cardRepository.findAll().size());

//			var card1 = cardRepository.save(new Card(cardArrangement1, Status.ACTIVE));
//			var card2 = cardRepository.save(new Card(cardArrangement1, Status.INACTIVE));
//			var card3 = cardRepository.save(new Card(cardArrangement2, Status.ACTIVE));
		};
	}

//	@Bean
//	CommandLineRunner commandLineRunner2(
//			CustomerRepository customerRepository,
//			CardArrangementRepository cardArrangementRepository,
//			CardRepository cardRepository) {
//		return args -> {
////			add some data
//			Customer customer1 = customerRepository.save(new Customer(AuthorizationLevel.LEVEL_2));
//			Customer customer2 = customerRepository.save(new Customer(AuthorizationLevel.LEVEL_3));
//			customer1.cardArrangements.add(new CardArrangement(customer1));
//			customer1.cardArrangements.add(new CardArrangement(customer1));
//			customer2.cardArrangements.add(new CardArrangement(customer2));//
//			System.out.println("Customer1 cardArrangement: "+ customer1.getCardArrangements());
//			System.out.println("Customer2 cardArrangement: "+ customer2.getCardArrangements());
//
//			customer1.getCardArrangements().get(0).getCards().add(new Card(Status.ACTIVE));
//
////			var card1 = cardRepository.save(new Card(cardArrangement1, Status.ACTIVE));
////			var card2 = cardRepository.save(new Card(cardArrangement1, Status.INACTIVE));
////			var card3 = cardRepository.save(new Card(cardArrangement2, Status.ACTIVE));
//		};
//	}

}
