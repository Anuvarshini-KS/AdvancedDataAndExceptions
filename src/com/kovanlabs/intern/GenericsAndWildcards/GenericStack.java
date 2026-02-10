package com.kovanlabs.intern.GenericsAndWildcards;

import java.util.ArrayList;

class Stack<T>
{
    ArrayList<T> A;
    int top=-1;
    int size;
    Stack(int size)
    {
        this.size=size;
        this.A=new ArrayList<>(size);
    }
    void push(T X)
    {
        if(top+1 == size)
        {
            size*=2;
            //System.out.println("Resized Array size : "+size);
        }
        top++;
        if(A.size()>top)
        {
            A.set(top,X);
        }
        else
        {
            A.add(X);
        }
    }
    void pop()
    {
        if(top==-1)
        {
            System.out.println("Stack Underflow");
            return;
        }
        top--;
    }
    T top()
    {
        if(top==-1)
        {
            System.out.println("Stack Underflow");
            return null;
        }
        return A.get(top);
    }
    boolean empty()
    {
        return top==-1;
    }
    public String toString()
    {
        String Ans = "";
        for(int i=0;i<top;i++)
        {
            Ans += String.valueOf(A.get(i)+"->");
        }
        Ans += String.valueOf(A.get(top));
        return Ans;
    }
}
public class GenericStack {
    public static void main(String[]args)
    {
        Stack<Integer> s1 = new Stack<>(2);
        s1.pop();
        s1.push(1);
        s1.push(2);
        System.out.println(s1);
        s1.push(3);
        System.out.println(s1);

        Stack<String> s2 = new Stack<>(3);
        s2.empty();
        s2.push("Sri");
        s2.push("hari");
        s2.push("joe");
        s2.push("pavi");
        System.out.println(s2);
    }
}
