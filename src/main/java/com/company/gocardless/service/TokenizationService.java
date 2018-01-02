package com.company.gocardless.service;

import com.company.gocardless.entity.PaymentDetailsResponse;
import com.company.gocardless.entity.RedirectFlowRequest;

public interface TokenizationService {

    RedirectFlowRequest getPaymentProviderUrl();

    PaymentDetailsResponse getPaymentDetailsByReference(long id);

}
