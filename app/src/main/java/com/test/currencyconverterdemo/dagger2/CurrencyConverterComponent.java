package com.test.currencyconverterdemo.dagger2;

import com.test.currencyconverterdemo.MainActivity;

import dagger.Component;

/**
 * Created by filippo on 26/02/2018.
 */

@Component(modules = CurrencyConverterModule.class)
public interface CurrencyConverterComponent {

    void inject(MainActivity activity);
}
