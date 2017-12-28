package com.company.gocardless.service;

import com.company.gocardless.entity.RedirectFlowRequest;

public interface TokenisationService {

    RedirectFlowRequest getPaymentProviderUrl();

}
