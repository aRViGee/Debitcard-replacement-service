package com.sogyo.rvgelder.ipdebitcardreplacementflow.service;


import com.sogyo.rvgelder.ipdebitcardreplacementflow.entity.*;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CustomerServiceImpl implements CustomerService {

//    @Autowired
//    private CustomerRepository customerRepository;

    public void replaceCard(String customerNumber, String cardNumber) {
        if (verifyCardReplacement(customerNumber,cardNumber)) {
            if (true/*TODO - External authorization implementation*/) {
//                TODO - Fulfillment:
//                  TODO - Fulfillment - Create new card
//                      TODO - Fulfillment - if new card created: set end_date current card
            }
//
        }
    }

    private boolean verifyCardReplacement(String customerNumber, String cardNumber) {
        return (isOwnerOfCard(customerNumber,cardNumber)) && (isAllowedToReplace(customerNumber,cardNumber));
    }

    private boolean isAllowedToReplace(String customerNumber, String cardNumber) {
        return false;
    }

    private boolean isOwnerOfCard(String customerNumber, String cardNumber) {

        return false;
    }

    public Customer createCustomer(String customerNumber, AuthorizationLevel authorizationLevel, List<CardArrangement> cardArrangements) {
        return new Customer(customerNumber, authorizationLevel, cardArrangements);
    }

    @Override
    public Customer createCompleteCustomer(String customerNumber, AuthorizationLevel authorizationLevel, List<CardArrangement> cardArrangements) {
        Customer customer = new Customer(customerNumber, authorizationLevel, null);
        CardArrangement cardArrangement = new CardArrangement("DebitCardArrangement", null);
        Card card = new Card("0A1B2C4D", Status.ACTIVE);
        cardArrangement.getCards().add(card);
        customer.getCardArrangements().add(cardArrangement);
        return customer;
    }


//    public CardArrangement createCardArrangement(String cardArrangementType, List<Card> cards) {
//        return new CardArrangement(cardArrangementType, cards);
//    }
    public Card createNewCard() {
        return new Card();
    }
}



