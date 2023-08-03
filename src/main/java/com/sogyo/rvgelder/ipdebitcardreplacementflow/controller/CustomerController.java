package com.sogyo.rvgelder.ipdebitcardreplacementflow.controller;

import com.sogyo.rvgelder.ipdebitcardreplacementflow.entity.Card;
import com.sogyo.rvgelder.ipdebitcardreplacementflow.entity.Customer;
import com.sogyo.rvgelder.ipdebitcardreplacementflow.entity.exceptions.*;
import com.sogyo.rvgelder.ipdebitcardreplacementflow.service.CustomerService;
import com.sogyo.rvgelder.ipdebitcardreplacementflow.service.exceptions.CardNotFoundException;
import com.sogyo.rvgelder.ipdebitcardreplacementflow.service.exceptions.CustomerNotAuthorizedException;
import com.sogyo.rvgelder.ipdebitcardreplacementflow.service.exceptions.CustomerNotFoundException;
import com.sogyo.rvgelder.ipdebitcardreplacementflow.service.exceptions.CustomerNotSavedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/")
public class CustomerController {

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @GetMapping(path = "/customers/number")
    public ResponseEntity<?> getCustomer(@RequestParam String customerNumber) {
        try {
            Customer customer = customerService.getCustomerByCustomerNumber(customerNumber);
            return ResponseEntity.ok(customer);
        } catch (CustomerNotFoundException exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
        }
        catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred.");
        }
    }

    @GetMapping(path = "/replace/debitCard")
    public ResponseEntity<String> replaceDebitCard(@RequestParam String customerNumber, String cardNumber) {
        try {
            Card newCard = customerService.replaceCard(customerNumber, cardNumber);
            return ResponseEntity.status(HttpStatus.CREATED).body("A new card has been added to your account, with card number: " + newCard.getCardNumber());

        } catch (CardNotFoundException | CustomerNotFoundException exception) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());

        } catch (CustomerNotAllowedToReplaceException | CustomerNotOwnerOfCardException | CustomerNotAuthorizedException |
                 StartDateInThePastException | CardIsInactiveException exception) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(exception.getMessage());

        } catch (CustomerNotSavedException | CardNotCreatedException | NewEndDateOldCardNotSetException exception) {
            return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body("Error creating card: " + exception.getMessage() + "." + "\nCard replacement failed for card with card number " + cardNumber + " and could not be replaced. \nPlease try again or contact customer service.");

        } catch (Exception exception) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error server side");
        }
    }
}
