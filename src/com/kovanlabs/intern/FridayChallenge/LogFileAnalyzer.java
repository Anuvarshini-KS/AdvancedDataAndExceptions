package com.kovanlabs.intern.FridayChallenge;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

class LogGenerator
{
    private static final String[] URls = {"/home","/login","/products","/cart","/checkout","/profile"};
    private static final int[] STATUS_CODES = {200,200,200,404,500};
    public static void main(String[]args)
    {
        Random random = new Random();
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("server.log"))){
            for(int i=0;i<10000;i++)
            {
                String ip = random.nextInt(256)+"."+ random.nextInt(256)+"."+ random.nextInt(256)+"."+random.nextInt(256);
                String timeStamp = LocalDateTime.now().minusSeconds(random.nextInt(1000)).toString();
                int status = STATUS_CODES[random.nextInt(STATUS_CODES.length)];
                String url = URls[random.nextInt(URls.length)];
                writer.write(ip+" "+timeStamp+" "+status+" "+url);
                writer.newLine();
            }
            System.out.println("server.log file generated with 10,000 entries.");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
class LogFileAnalyzer {
    public static void main(String[]args) throws IOException
    {
        Path logPath = Path.of("server.log");
        List<String> logs = Files.lines(logPath).toList();
        Map<String,Long> requestPerIp = logs.stream().map(line -> line.split(" ")[0]).collect(Collectors.groupingBy(ip -> ip,Collectors.counting()));
        System.out.println("Request per IP");
        requestPerIp.forEach((ip,count) -> System.out.println(ip+"->"+count));
        System.out.println("\nTop 3 Requested URLs:");
        logs.stream().map(line -> line.split(" ")[3]).collect(Collectors.groupingBy(url -> url,
                        Collectors.counting())).entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).limit(3).forEach(entry ->
                        System.out.println(entry.getKey() + " -> " + entry.getValue()));
        long totalRequests = logs.size();
        long error404Count = logs.stream().map(line -> line.split(" ")[2]).filter(code -> code.equals("404")).count();
        double percentage404 = (error404Count * 100.0) / totalRequests;
        System.out.println("\n404 Error Percentage: " + percentage404 + "%");




    }
}
