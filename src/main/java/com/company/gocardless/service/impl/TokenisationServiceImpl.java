package com.company.gocardless.service.impl;

import com.company.gocardless.entity.RedirectFlowRequest;
import com.company.gocardless.repository.RedirectFlowRequestRepository;
import com.company.gocardless.service.TokenisationService;
import com.company.gocardless.service.clientFactory.ClientFactory;
import com.gocardless.GoCardlessClient;
import com.gocardless.resources.RedirectFlow;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TokenisationServiceImpl implements TokenisationService {

    @Autowired
    private ClientFactory clientFactory;

    @Autowired
    private RedirectFlowRequestRepository redirectFlowRequestRepository;

    public RedirectFlowRequest getPaymentProviderUrl() {
        RedirectFlowRequest redirectFlowRequest = new RedirectFlowRequest();
        GoCardlessClient client = clientFactory.get();
        RedirectFlow execute = client.redirectFlows().create().withSessionToken(generateToken())
                .withSuccessRedirectUrl("https://www.google.com").execute();
        redirectFlowRequest.setUrl(execute.getRedirectUrl());
        redirectFlowRequest.setRedirectFlowId(execute.getId());
        redirectFlowRequestRepository.save(redirectFlowRequest);
        return redirectFlowRequest;
    }

    private String generateToken() {
       return RandomStringUtils.random(25, true, true);
    }
}
