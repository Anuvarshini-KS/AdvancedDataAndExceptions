package com.kovanlabs.intern.GenericsAndWildcards;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WildcardSum {
    public static double addList(List<? extends Number> list)
    {
        double sum=0.0;
        for(Number num : list)
        {
            sum += num.doubleValue();
        }
        return sum;
    }
    public static void main(String[]args)
    {
        List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5);
        List<Double> doubleList = Arrays.asList(2.3,8.5,6.7);
        System.out.println("The sum of Integer list is : "+addList(intList));
        System.out.println("The sum of Double list is : "+addList(doubleList));
        List<Float> floatList = Arrays.asList(2.34f,5.67f,9.76f);
        List<Long> longList = Arrays.asList(4345l,8765l,7654l,8943l);
        System.out.println("The sum of FLoat list is : "+addList(floatList));
        System.out.println("The sum of Long list is : "+addList(longList));

     }
}
