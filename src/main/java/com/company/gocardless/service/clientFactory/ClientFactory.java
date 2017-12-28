package com.company.gocardless.service.clientFactory;

import com.gocardless.GoCardlessClient;
import org.springframework.stereotype.Component;

@Component
public class ClientFactory {

    public GoCardlessClient get() {
    return GoCardlessClient.create("sandbox_iOXervAxenmkHEhojqK5cD2wsDPfoAa6zRNKFJpj",
            GoCardlessClient.Environment.SANDBOX );
    }
}
