package com.test.currencyconverterdemo.dagger2;

import com.test.currencyconverterdemo.CurrencyConverter;
import com.test.currencyconverterdemo.OfflineCurrencyConverter;
import com.test.currencyconverterdemo.OnlineCurrencyConverter;
import com.test.currencyconverterdemo.api.CurrencyConverterApi;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by filippo on 26/02/2018.
 */

@Module
public class CurrencyConverterModule {

    private final CurrencyConverter.ConversionListener conversionListener;

    public CurrencyConverterModule(CurrencyConverter.ConversionListener conversionListener) {
        this.conversionListener = conversionListener;
    }

    @Provides
    CurrencyConverter.ConversionListener provideConversionListener() {
        return this.conversionListener;
    }

    @Provides
    @Named("offline")
    CurrencyConverter provideCurrencyConverter(OfflineCurrencyConverter converter) {
        return converter;
    }

    @Provides
    @Named("online")
    CurrencyConverter provideOnlineCurrencyConverter(OnlineCurrencyConverter currencyConverter) {
        return currencyConverter;
    }

    @Provides
    Retrofit provideRetrofit() {
        return new Retrofit.Builder()
                .baseUrl("https://api.fixer.io")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Provides
    CurrencyConverterApi provideConverterApi(Retrofit retrofit) {
        return retrofit.create(CurrencyConverterApi.class);
    }
}
