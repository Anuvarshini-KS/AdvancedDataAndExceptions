package com.kovanlabs.intern.ExceptionHandling;
class MyResources implements AutoCloseable{
    public MyResources()
    {
        System.out.println("Resource created");
    }
    void doWork()
    {
        System.out.println("Work In-Progress");
    }
    @Override
    public void close() throws Exception {
       System.out.println("Resource closed");
    }
}
public class AutoClose {
    public static void main(String[] args)
    {
        try(MyResources resource = new MyResources())
        {
            System.out.println("Inside try block");
            resource.doWork();
            int num = 10/0;
        }
        catch (Exception e)
        {
            System.out.println("Exception caught"+e);
        }

    }
}
