package com.company.gocardless.service.impl;

import com.company.gocardless.entity.PaymentDetailsResponse;
import com.company.gocardless.entity.RedirectFlowRequest;
import com.company.gocardless.repository.PaymentDetailsResponseRepository;
import com.company.gocardless.repository.RedirectFlowRequestRepository;
import com.company.gocardless.service.TokenizationService;
import com.gocardless.GoCardlessClient;
import com.gocardless.resources.RedirectFlow;
import com.gocardless.services.RedirectFlowService;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
public class TokenizationServiceImpl implements TokenizationService {

    @Autowired
    private GoCardlessClient goCardlessClient;

    @Autowired
    private RedirectFlowRequestRepository redirectFlowRequestRepository;

    @Autowired
    private PaymentDetailsResponseRepository paymentDetailsResponseRepository;

    @Override
    @Transactional
    public RedirectFlowRequest getPaymentProviderUrl() {
        String sessionToken = generateToken();
        RedirectFlowRequest redirectFlowRequest = new RedirectFlowRequest();
        RedirectFlow execute = goCardlessClient.redirectFlows().create().withSessionToken(sessionToken)
                .withSuccessRedirectUrl("https://www.google.com").execute();
        redirectFlowRequest.setUrl(execute.getRedirectUrl());
        redirectFlowRequest.setRedirectFlowId(execute.getId());
        redirectFlowRequest.setSessionToken(sessionToken);
        redirectFlowRequestRepository.save(redirectFlowRequest);
        return redirectFlowRequest;
    }

    @Override
    @Transactional
    public PaymentDetailsResponse getPaymentDetailsByReference(long id) {
        RedirectFlowRequest redirectFlowRequest = redirectFlowRequestRepository.findById(id);
        PaymentDetailsResponse paymentDetailsResponse = new PaymentDetailsResponse();
        RedirectFlowService.RedirectFlowCompleteRequest redirectFlowCompleteRequest =
                goCardlessClient.redirectFlows().complete(redirectFlowRequest.getRedirectFlowId())
                        .withSessionToken(redirectFlowRequest.getSessionToken());
        RedirectFlow flow = redirectFlowCompleteRequest.execute();
        paymentDetailsResponse.setCustomer(flow.getLinks().getCustomer());
        paymentDetailsResponse.setMandate(flow.getLinks().getMandate());
        paymentDetailsResponseRepository.save(paymentDetailsResponse);
        return paymentDetailsResponse;
    }

    private String generateToken() {
       return RandomStringUtils.random(25, true, true);
    }
}
