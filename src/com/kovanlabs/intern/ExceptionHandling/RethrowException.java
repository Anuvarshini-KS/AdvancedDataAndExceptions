package com.kovanlabs.intern.ExceptionHandling;

import java.io.IOException;

class DataProcessingException extends RuntimeException
{
    DataProcessingException(String message, Throwable cause )
    {
        super(message,cause);
    }
}
class Data
{
    static void getData() throws IOException
    {
        throw new IOException("File is not accessible");
    }
}
class Service
{
    static void getService() throws DataProcessingException
    {
        try{
            Data.getData();
        }catch(IOException e)
        {
            throw new DataProcessingException("Unable to get data ",e);
        }
    }
}
public class RethrowException {
    public static void main(String[]args)
    {
        try{
            Service.getService();
        }catch(DataProcessingException e)
        {
            System.out.println("Custom Exception : "+e.getMessage());
            System.out.println("Root cause : ");
            e.printStackTrace();
        }
    }
}
