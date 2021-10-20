package com.epam.brest.model;

import com.epam.brest.calc.ImplCalc;
import com.epam.brest.selector.PriceSelector;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Properties;
import java.util.Scanner;

import static java.lang.System.*;

public class Calc extends AbstractStatus{



    public Calc(Scanner scanner, Map<Integer, BigDecimal> pricePerKg, Map<Integer, BigDecimal> pricePerKm) {
        this.scanner = scanner;
        this.pricePerKg = pricePerKg;
        this.pricePerKm = pricePerKm;
    }


    @Override
    public Status handle() {
try{
    BigDecimal pricePerKgValue = new  PriceSelector().priceSelectorValue(pricePerKg, userData.get(0));
BigDecimal pricePerKmValue = new PriceSelector().priceSelectorValue(pricePerKm,userData.get(1));
BigDecimal result = new ImplCalc().handle(pricePerKgValue,userData.get(0),pricePerKmValue,userData.get(1));
    out.println("Result = " + userData.get(0).multiply(BigDecimal.valueOf(1)).add(userData.get(1).multiply(BigDecimal.valueOf(1))));
}

finally {
    userData.clear();
}
return new ReadData(scanner,pricePerKg,pricePerKm);
    }

    @Override
    public StatusType getType() {
        return StatusType.CALC;
    }
}
