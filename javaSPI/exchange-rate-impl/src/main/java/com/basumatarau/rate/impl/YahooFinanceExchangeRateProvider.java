package com.basumatarau.rate.impl;

import com.basumatarau.rate.api.QuoteManager;
import com.basumatarau.rate.spi.ExchangeRateProvider;

public class YahooFinanceExchangeRateProvider implements ExchangeRateProvider {
    @Override
    public QuoteManager create() {
        return new YahooQuoteManagerImpl();
    }
}
