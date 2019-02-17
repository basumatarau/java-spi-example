package com.basumatarau.rate.spi;

import com.basumatarau.rate.api.QuoteManager;

public interface ExchangeRateProvider {
    QuoteManager create();
}
