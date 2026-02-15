package com.kovanlabs.intern.Stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Employee
{
    public String name,department;
    Employee(String name,String department)
    {
        this.name=name;
        this.department=department;
    }
//    public String getName()
//    {
//        return name;
//    }
//    public String getDepartment()
//    {
//        return department;
//    }

    @Override
    public String toString() {
        return name + " (" + department + ")";
    }
}
public class Grouping {
    public static void main(String[]args)
    {
        List<Employee> list = Arrays.asList(new Employee("Ram","IT"),new Employee("Sri","HR"));
        Map<String, List<Employee>> map = list.stream().collect(Collectors.groupingBy(e -> e.department));
        System.out.println(map);
    }
}
