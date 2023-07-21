package com.sogyo.rvgelder.ipdebitcardreplacementflow.repository;

import com.sogyo.rvgelder.ipdebitcardreplacementflow.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findByCustomerNumber(String customerNumber);

}
