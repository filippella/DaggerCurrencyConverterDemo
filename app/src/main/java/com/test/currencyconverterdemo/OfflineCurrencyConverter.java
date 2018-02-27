package com.test.currencyconverterdemo;

import javax.inject.Inject;

/**
 * Created by filippo on 26/02/2018.
 */

public class OfflineCurrencyConverter implements CurrencyConverter {

    @Inject ConversionListener conversionListener;

    @Inject
    public OfflineCurrencyConverter() {
    }

    @Override
    public void convertPoundToDollar(double amount) {
        conversionListener.convertedValue(amount * 1.40);
    }

    @Override
    public void convertPoundToEuro(double amount) {
        conversionListener.convertedValue(amount * 1.40);
    }
}
