package com.company.gocardless.service.impl;

import com.company.gocardless.service.PaymentService;
import com.company.gocardless.service.clientFactory.ClientFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private ClientFactory clientFactory;

    public boolean performedPayment() {
        return false;
    }
}
