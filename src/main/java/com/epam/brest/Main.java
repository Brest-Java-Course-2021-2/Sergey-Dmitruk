package com.epam.brest;

import com.epam.brest.files.CSVFileReader;
import com.epam.brest.files.FileReader;
import com.epam.brest.model.AbstractStatus;
import com.epam.brest.model.ReadData;
import com.epam.brest.model.Status;
import com.epam.brest.model.StatusType;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
        FileReader fileReader = (FileReader) context.getBean("FileReader");




        Map<Integer, BigDecimal> pricePerKgMap = fileReader.readData("price_weight.csv");
        Map<Integer, BigDecimal> pricePerKmMap = fileReader.readData("price_km.csv");



        try (Scanner scanner = new Scanner(System.in)) {
            Status readData = new ReadData(scanner, pricePerKgMap, pricePerKmMap);
            while (readData.getType() != StatusType.EXIT) {
                readData = readData.handle();
            }
        }
    }


}
