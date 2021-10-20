package com.epam.brest.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface Status {
    Status handle();
    StatusType getType();
    List<String> messages = new ArrayList<>(Arrays.asList("Entered value weight", "Entered value km"));
    List<BigDecimal> userData = new ArrayList<>();
}
