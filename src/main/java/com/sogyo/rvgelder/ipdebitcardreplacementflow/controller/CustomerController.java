package com.sogyo.rvgelder.ipdebitcardreplacementflow.controller;

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
//        return customerNumber;
    }

    @GetMapping(path = "/replaceDebitCard")
    public void replaceDebitCard(@RequestParam String customerNumber, String cardNumber) {
        customerService.replaceCard(customerNumber, cardNumber);
    }
}
