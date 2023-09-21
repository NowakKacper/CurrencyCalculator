package com.nowakkacper.CurrencyConverterApp.model;

public class RequestModel {
    private float amount;
    private float afterConversion;
    private String fromCurrency;
    private String onCurrency;

    public RequestModel() {
        afterConversion = 0;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public float getAfterConversion() {
        return afterConversion;
    }

    public void setAfterConversion(float afterConversion) {
        this.afterConversion = afterConversion;
    }

    public String getFromCurrency() {
        return fromCurrency;
    }

    public void setFromCurrency(String fromCurrency) {
        this.fromCurrency = fromCurrency;
    }

    public String getOnCurrency() {
        return onCurrency;
    }

    public void setOnCurrency(String onCurrency) {
        this.onCurrency = onCurrency;
    }
}
