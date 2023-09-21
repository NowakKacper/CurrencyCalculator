package com.nowakkacper.CurrencyConverterApp.logic;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nowakkacper.CurrencyConverterApp.model.CurrencyValues;
import com.nowakkacper.CurrencyConverterApp.model.RequestModel;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ConverterService {
    private final RestTemplate restTemplate = new RestTemplateBuilder().build();
    private CurrencyValues responseBody;
    private String lastChoice = "";

    public void convert(RequestModel data) throws JsonProcessingException {
        if(data.getFromCurrency().equals(lastChoice)){
            convertWithPreviousData(data);
        } else{
            lastChoice = data.getFromCurrency();
            convertByConnectingToRESTAPI(data);
        }
    }

    private void convertWithPreviousData(RequestModel data) {
        calculateAmountAfterConversion(data);
    }

    private void convertByConnectingToRESTAPI(RequestModel data) throws JsonProcessingException {
        String cos = data.getFromCurrency();
        ResponseEntity<String> response = restTemplate.getForEntity(
                "https://openexchangerates.org/api/latest.json?app_id=a4efee89d6324103ad0432093581aada&base=" +
                        cos + "&symbols=AUD,CAD,CHF,EUR,GBP,JPY,NOK,PLN,SEK,USD", String.class);
        String jsonResponse = response.getBody();
        ObjectMapper objectMapper = new ObjectMapper();
        responseBody = objectMapper.readValue(jsonResponse, CurrencyValues.class);
        calculateAmountAfterConversion(data);
    }

    private void calculateAmountAfterConversion(RequestModel data) {
        double value = getCurrencyValue(data.getOnCurrency());
        double newAmount = data.getAmount()*value;
        double rounded = Math.round(newAmount * 100.0) / 100.0;
        data.setAfterConversion((float) rounded);
    }

    private double getCurrencyValue(String onCurrency){
        String sentence = responseBody.toString();
        int indexOfLookingCurrencyInToString = sentence.indexOf(onCurrency);
        String sub = sentence.substring(indexOfLookingCurrencyInToString);
        int indexOfComma = sub.indexOf(",");
        if(indexOfComma == -1) indexOfComma = sub.length()-1;
        String currencyValueInString = sub.substring(4, indexOfComma);
        return Double.parseDouble(currencyValueInString);
    }
}
