package com.nowakkacper.CurrencyConverterApp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrencyValues {
    private Rates rates;

    public Rates getRates() {
        return rates;
    }

    @Override
    public String toString() {
        return rates.toString();
    }

    public static class Rates {
        @JsonProperty("AUD")
        private double AUD;
        @JsonProperty("CAD")
        private double CAD;

        @JsonProperty("CHF")
        private double CHF;

        @JsonProperty("EUR")
        private double EUR;

        @JsonProperty("GBP")
        private double GBP;

        @JsonProperty("JPY")
        private double JPY;

        @JsonProperty("NOK")
        private double NOK;

        @JsonProperty("PLN")
        private double PLN;

        @JsonProperty("SEK")
        private double SEK;

        @JsonProperty("USD")
        private double USD;

        public double getUSD() {
            return USD;
        }

        public double getEUR() {
            return EUR;
        }

        public double getJPY() {
            return JPY;
        }

        public double getGBP() {
            return GBP;
        }

        public double getAUD() {
            return AUD;
        }

        public double getCAD() {
            return CAD;
        }

        public double getCHF() {
            return CHF;
        }

        public double getSEK() {
            return SEK;
        }

        public double getNOK() {
            return NOK;
        }

        public double getPLN() {
            return PLN;
        }

        @Override
        public String toString() {
            return "Rates{" +
                    "USD=" + USD +
                    ", EUR=" + EUR +
                    ", JPY=" + JPY +
                    ", GBP=" + GBP +
                    ", AUD=" + AUD +
                    ", CAD=" + CAD +
                    ", CHF=" + CHF +
                    ", SEK=" + SEK +
                    ", NOK=" + NOK +
                    ", PLN=" + PLN +
                    '}';
        }
    }
}
