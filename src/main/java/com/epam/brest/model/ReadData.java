package com.epam.brest.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Map;
import java.util.Scanner;

public class ReadData extends AbstractStatus{

    public static final int NUMBER_VALUES = 2;


    public ReadData(Scanner scanner,Map<Integer, BigDecimal> pricePerKg, Map<Integer, BigDecimal> pricePerKm) {
        this.scanner = scanner;
        this.pricePerKg = pricePerKg;
        this.pricePerKm = pricePerKm;
    }

    @Override
    public Status handle() {

        if(userData.size() < NUMBER_VALUES) {
            System.out.println(Status.messages.get(Status.userData.size()));
            String inputValue = scanner.next();

            if(inputValue.equalsIgnoreCase("q")){
                return new Exit(); }
            else if(isCorrectValue(inputValue)){
                userData.add(new BigDecimal(inputValue));
            }

        }
        else new Calc(scanner,pricePerKg,pricePerKm).handle();
        return this;
    }

    private boolean isCorrectValue(String inputValue) {
        try{
            BigDecimal enteredValue = new BigDecimal(inputValue);

            return enteredValue.doubleValue() > 0;
        }catch (NumberFormatException e){
            System.out.println("Incorrect value: " + inputValue);

        }
        return false;


    }

    @Override
    public StatusType getType() {
        return StatusType.READ_DATA;
    }
}
