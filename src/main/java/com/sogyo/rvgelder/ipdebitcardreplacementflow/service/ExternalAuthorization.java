package com.sogyo.rvgelder.ipdebitcardreplacementflow.service;

import com.sogyo.rvgelder.ipdebitcardreplacementflow.entity.Customer;

public interface ExternalAuthorization {

    boolean isAuthorized(Customer customer, Integer processId);
}
