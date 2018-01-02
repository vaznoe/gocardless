package com.company.gocardless.repository;

import com.company.gocardless.entity.PaymentDetailsResponse;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentDetailsResponseRepository extends CrudRepository<PaymentDetailsResponse, Long> {

    PaymentDetailsResponse findById(long id);

}
