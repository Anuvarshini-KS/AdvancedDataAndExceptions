package com.kovanlabs.intern.Collections;

import java.util.ArrayList;
import java.util.LinkedList;

public class PerformanceTest {
    public static void main(String[]args)
    {
        int size = 100000;
        ArrayList<Integer> list = new ArrayList<>();
        LinkedList<Integer> linkedlist = new LinkedList<>();
        for(int i=0;i<size;i++)
        {
            list.add(i);
            linkedlist.add(i);
        }
        int middleSize = size/2;
        long startTime = System.nanoTime();
        list.get(middleSize);
        long endTime = System.nanoTime();
        long arrayListTime = endTime-startTime;

        startTime = System.nanoTime();
        linkedlist.get(middleSize);
        endTime = System.nanoTime();
        long linkedListTime = endTime-startTime;
        System.out.println("Time taken by ArrayList to find middle element in 1 Billion elements is "+arrayListTime+" nano seconds");
        System.out.println("Time taken by LinkedList to find middle element in 1 Billion elements is "+linkedListTime+" nano seconds");

       if(arrayListTime<linkedListTime)
       {
           System.out.println("Array list works better when compared to linked list. ");
       }
       else
       {
           System.out.println("LinkedList works better when compared to array list");
       }
    }
}
