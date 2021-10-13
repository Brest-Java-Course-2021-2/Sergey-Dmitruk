package com.epam.brest.calc;

import java.math.BigDecimal;

public class ImplCalc implements Calc{
    @Override
    public  BigDecimal handle(BigDecimal weight, BigDecimal pricePerKg, BigDecimal km, BigDecimal pricePerKm) {
         return weight.multiply(pricePerKg).add(km.multiply(pricePerKm));
    }
}
