package com.sogyo.rvgelder.ipdebitcardreplacementflow.service;


import com.sogyo.rvgelder.ipdebitcardreplacementflow.entity.*;
import org.springframework.stereotype.Service;


@Service
public class CustomerServiceImpl implements CustomerService, ExternalAuthorization {


    public void replaceCard(Customer customer, String cardNumber) {
        if (CardReplacementIsValid(customer, cardNumber)) {
            if (isAuthorized(3)/*TODO - External authorization implementation*/) {
//                TODO - Fulfillment:
//                  TODO - Fulfillment - Create new card
//                      TODO - Fulfillment - if new card created: set end_date current card
            }
//
        }
    }

    public boolean isAuthorized(Integer processId) {
        return true;
    }

    private boolean CardReplacementIsValid(Customer customer, String cardNumber) {
        return (isOwnerOfCard(customer, cardNumber)) && (isAllowedToReplace(customer));
    }

    private boolean isOwnerOfCard(Customer customer, String cardNumber) {
        for (int indexCardArrangements = 0; indexCardArrangements < customer.getCardArrangements().size(); indexCardArrangements++) {
            for (int indexCards = 0; indexCards < customer.getCardArrangements().get(indexCardArrangements).getCards().size(); indexCards++) {
                if(customer.getCardArrangements().get(indexCardArrangements).getCards().get(indexCards).getCardNumber().equals(cardNumber)) {
                    return true;
                }
            }
        } return false;
    }

    private boolean isAllowedToReplace(Customer customer) {
        return AuthorizationLevel.checkAllowedActions(customer.getAuthorizationLevel());
    }

//    Customer method implementation

    @Override
    public AuthorizationLevel getAuthorizationLevel(Customer customer) {
        return customer.getAuthorizationLevel();
    }


//    CardArrangement method implementations
    @Override
    public CardArrangement getCardArrangementById(Customer customer, Integer id) {
        return customer.getCardArrangements().get(id);
    }

    @Override
    public CardArrangement getCardArrangementByType(Customer customer, String cardArrangementType) {
//        TODO - Refactor with recursion
        for (int index = 0; index < customer.getCardArrangements().size(); index++) {
            if (customer.getCardArrangements().get(index).equals(cardArrangementType)) {
                return customer.getCardArrangements().get(index);
            }
        }
        return null;
    }

}



