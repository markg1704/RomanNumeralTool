package com.markg1704.controllers;

import com.markg1704.conversion.RomanNumeralConverter;
import com.markg1704.model.RomanNumeral;
import com.markg1704.model.RouteMap;
import com.markg1704.model.ViewNames;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    private static final String PARAM_CALCULATE = "calculate";
    private static final String PARAM_VALUE_REQUEST = "intnum";

    private static final String ATTRIB_ROMAN_NUMERAL = "romannumeral";

    private final RomanNumeralConverter converter;

    public HomeController() {

        this.converter = new RomanNumeralConverter();

    }

    @GetMapping(RouteMap.HOME)
    public String showHomePage() {

        return ViewNames.HOME;
    }


    @PostMapping(value = RouteMap.HOME, params = PARAM_CALCULATE)
    public ModelAndView convertAction(@RequestParam(PARAM_VALUE_REQUEST) int value) {

        RomanNumeral numeral = converter.convert(value);

        if (numeral == null)
            return new ModelAndView(ViewNames.HOME);

        ModelAndView modelAndView = new ModelAndView(ViewNames.RESULT);

        modelAndView.addObject(ATTRIB_ROMAN_NUMERAL, numeral);

        return modelAndView;
    }

}
