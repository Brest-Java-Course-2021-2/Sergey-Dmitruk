package com.epam.brest;

import com.epam.brest.calc.ImplCalc;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BigDecimal weight, pricePerKg, km, pricePerKm;
        try (Scanner scanner = new Scanner(System.in)) {
          do {
                weight = getValueFromCon(scanner, "Enter weight");
                pricePerKg = getValueFromCon(scanner, "Enter Price per kilogram");
                km = getValueFromCon(scanner, "Enter length(km)");
                pricePerKm = getValueFromCon(scanner, "Enter price per kilometre");

            } while (!scanner.hasNext("q"));
            System.out.println("Result = " + new ImplCalc().handle(weight,pricePerKg,km,pricePerKm));
        }

    }
    private static BigDecimal getValueFromCon(Scanner scanner, String outputMessage){
        BigDecimal valueCon;
        System.out.print(outputMessage);
        valueCon =
                scanner.nextBigDecimal();

        return valueCon;
    }

}
