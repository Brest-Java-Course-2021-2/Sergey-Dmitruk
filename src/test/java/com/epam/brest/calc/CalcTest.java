package com.epam.brest.calc;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;


import static org.junit.jupiter.api.Assertions.*;



class CalcTest {
Calc calc = new ImplCalc();

    @Test
    void TestHandle() {
        BigDecimal weight= new BigDecimal("10");
        BigDecimal weightPrice= new BigDecimal("10");
        BigDecimal distance= new BigDecimal("10");
        BigDecimal kmPrice= new BigDecimal("10");
    assertNotNull(calc);
     assertEquals(new BigDecimal("200"), calc.handle(weight,weightPrice,distance,kmPrice));
    }
    @Test
    void TestHandleNull() {
        assertNotNull(calc);
        assertThrows(IllegalArgumentException.class, ()->
                calc.handle(null,null,null,null));
    }
}