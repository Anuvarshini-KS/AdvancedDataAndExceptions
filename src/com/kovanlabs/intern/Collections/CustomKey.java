package com.kovanlabs.intern.Collections;

import java.util.HashMap;

class Person
{
    String name;
    int age;
    Person(String name,int age)
    {
        this.name=name;
        this.age=age;
    }

    @Override
    public boolean equals(Object obj) {
        Person p = (Person) obj;
        return this.name.equals(p.name) && this.age == p.age;
    }

    @Override
    public int hashCode() {
        return name.hashCode()+age;
    }
}

public class CustomKey {
    public static void main(String[]args)
    {
        HashMap<Person,String> map = new HashMap<>();
        Person p1 = new Person("Rash",22);
        Person p2 = new Person("Rash",22);
        map.put(p1,"Software Engineer");
        System.out.println(map.get(p2));
    }
}
