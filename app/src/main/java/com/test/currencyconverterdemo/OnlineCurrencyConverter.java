package com.test.currencyconverterdemo;

import javax.inject.Inject;

/**
 * Created by filippo on 27/02/2018.
 */

public class OnlineCurrencyConverter implements CurrencyConverter {

    private final CurrencyConverterDataSource dataSource;

    @Inject ConversionListener conversionListener;

    @Inject
    public OnlineCurrencyConverter(CurrencyConverterDataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void convertPoundToDollar(double amount) {
        this.dataSource.getRates(amount, conversionListener, "USD");
    }

    @Override
    public void convertPoundToEuro(double amount) {
        this.dataSource.getRates(amount, conversionListener, "EUR");
    }
}
