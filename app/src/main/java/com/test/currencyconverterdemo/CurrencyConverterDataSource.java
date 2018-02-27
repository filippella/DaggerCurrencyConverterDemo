package com.test.currencyconverterdemo;

import com.test.currencyconverterdemo.api.CurrencyConverterApi;
import com.test.currencyconverterdemo.model.Rates;
import com.test.currencyconverterdemo.model.RatesResponse;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by filippo on 27/02/2018.
 */

public class CurrencyConverterDataSource {

    @Inject CurrencyConverterApi converterApi;

    @Inject
    public CurrencyConverterDataSource() {
    }

    public void getRates(final double amount, final CurrencyConverter.ConversionListener listener, final String currency) {

        listener.onConversionStarted();

        converterApi.getCurrencies()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RatesResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RatesResponse ratesResponse) {
                        Rates rates = ratesResponse.getRates();

                        if (currency.equals("USD")) {
                            listener.convertedValue(amount * rates.getUSD());
                        } else {
                            listener.convertedValue(amount * rates.getEUR());
                        }
                        listener.onConversionCompleted();
                    }

                    @Override
                    public void onError(Throwable e) {
                        System.out.println(e.getMessage());
                        listener.onConversionCompleted();
                    }

                    @Override
                    public void onComplete() {
                        listener.onConversionCompleted();
                    }
                });
    }
}
