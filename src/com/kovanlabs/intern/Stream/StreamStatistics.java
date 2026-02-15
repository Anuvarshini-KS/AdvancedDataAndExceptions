package com.kovanlabs.intern.Stream;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class StreamStatistics {
    public static void main(String[]args)
    {
//        List<Integer> number = new Random().ints(100,1,1000).boxed().collect(Collectors.toList());
//        IntSummaryStatistics statistics = number.stream().mapToInt(Integer::intValue).summaryStatistics();
        IntSummaryStatistics statistics = new Random().ints(100,1,1000).summaryStatistics();
        System.out.println("Minimum : "+statistics.getMin());
        System.out.println("Maximum : "+statistics.getMax());
        System.out.println("Sum : "+statistics.getSum());
        System.out.println("Average : "+statistics.getAverage());
        System.out.println("Count : "+statistics.getCount());

    }
}
