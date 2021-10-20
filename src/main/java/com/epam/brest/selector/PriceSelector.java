package com.epam.brest.selector;

import java.math.BigDecimal;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class PriceSelector {
     public BigDecimal priceSelectorValue(Map<Integer,BigDecimal> map, BigDecimal target){
          SortedSet<Integer> sortedKeys = new TreeSet<>(map.keySet());
          Integer resultKey = sortedKeys.first();
          for(Integer key: sortedKeys){
               if(resultKey >= target.doubleValue())
                    break;
               resultKey = key;
          }
BigDecimal resultValue = map.get(resultKey);
          System.out.println("Value: " + target + " -> " + resultValue);
          return resultValue;

     }
}
