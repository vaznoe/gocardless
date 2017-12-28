package com.company.gocardless.controller;

import com.company.gocardless.entity.RedirectFlowRequest;
import com.company.gocardless.service.TokenisationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/gocardless")
public class GocardlessController {

    @Autowired
    private TokenisationService tokenisationService;

    @GetMapping("/getUrl")
    public RedirectFlowRequest getUrl() {
       return tokenisationService.getPaymentProviderUrl();
    }
}
