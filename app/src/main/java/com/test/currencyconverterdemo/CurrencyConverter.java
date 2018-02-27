package com.test.currencyconverterdemo;

/**
 * Created by filippo on 26/02/2018.
 */

public interface CurrencyConverter {

    void convertPoundToDollar(final double amount);

    void convertPoundToEuro(final double amount);

    interface ConversionListener {

        void onConversionStarted();

        void convertedValue(double convertedValue);

        void onConversionCompleted();
    }
}
