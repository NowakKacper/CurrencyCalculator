package com.nowakkacper.CurrencyConverterApp.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.nowakkacper.CurrencyConverterApp.logic.ConverterService;
import com.nowakkacper.CurrencyConverterApp.model.RequestModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/calculator")
public class ConverterController {
    private final ConverterService service;

    public ConverterController(ConverterService service) {
        this.service = service;
    }

    @GetMapping
    String showCalculator(Model model){
        model.addAttribute("calculate", new RequestModel());
        return "calculator";
    }

    @PostMapping
    String convert(@ModelAttribute("calculate") RequestModel data) throws JsonProcessingException {
        service.convert(data);
        return "calculator";
    }

}
