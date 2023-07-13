package com.sogyo.rvgelder.ipdebitcardreplacementflow.controller;

import com.sogyo.rvgelder.ipdebitcardreplacementflow.entity.Card;
import com.sogyo.rvgelder.ipdebitcardreplacementflow.entity.Customer;
import com.sogyo.rvgelder.ipdebitcardreplacementflow.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/replace")
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @GetMapping(path = "/CustomerByNumber")
    public Customer getCustomer(@RequestParam String customerNumber) {
        return customerService.getCustomerByCustomerNumber(customerNumber);
    }

    @GetMapping(path = "/replaceDebitCard")
    public String replaceDebitCard(@RequestParam String customerNumber, String cardNumber) {
        try {
            Card newCard = customerService.replaceCard(customerNumber, cardNumber);
            return "A new card has been added to your account, with card number: " + newCard.getCardNumber();

        } catch (Exception e) {
            return "Card replacement failed for card with card number " + cardNumber + " and could not be replaced. Try again or contact customer service.";
        }
    }
}
