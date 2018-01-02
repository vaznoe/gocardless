package com.company.gocardless.controller;

import com.company.gocardless.entity.PaymentDetailsResponse;
import com.company.gocardless.entity.RedirectFlowRequest;
import com.company.gocardless.service.TokenizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gocardless")
public class GocardlessController {

    @Autowired
    private TokenizationService tokenizationService;

    @GetMapping("/getUrl")
    public RedirectFlowRequest getUrl() {
       return tokenizationService.getPaymentProviderUrl();
    }

    @GetMapping("/getPaymentDetails/{id}")
    public PaymentDetailsResponse getPaymentDetails(@PathVariable long id) {
        return tokenizationService.getPaymentDetailsByReference(id);
    }
}
