package com.test.currencyconverterdemo.api;

import com.test.currencyconverterdemo.model.RatesResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by filippo on 27/02/2018.
 */

public interface CurrencyConverterApi {

    @GET("/latest?base=GBP")
    Observable<RatesResponse> getCurrencies();
}
