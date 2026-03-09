package com.kovanlabs.intern.FridayChallenge;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Random;

public class LogfileGenerator {
    static String[] urls = { "/home","/login","/logout","/signup","/cart","/payment","/products","/orders"};
    static int[] statusCodes = {200,200,200,404,500};
    public static void generate(String filename, int lines) throws IOException{
        Random random = new Random();
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        for(int i=0;i<lines;i++)
        {
            String ip = random.nextInt(256)+"."+
                    random.nextInt(256)+"."+
                    random.nextInt(256)+"."+
                    random.nextInt(256);
            String time = LocalDateTime.now().toString();
            int status = statusCodes[random.nextInt(statusCodes.length)];
            String url = urls[random.nextInt(urls.length)];
            writer.write(ip+" "+time+" "+status+" "+url);
            writer.newLine();
        }
        writer.close();
        System.out.println("Logs Generated");

    }
}
