package com.kovanlabs.intern.FridayChallenge;
import java.util.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.stream.Collectors;


public class LogfileAnalyzer {
    public static Map<String, Long> requestsPerIP(String filename) throws IOException {
        return Files.lines(Paths.get(filename))
                .map(line -> line.split(" "))
                .collect(Collectors.groupingBy(
                        parts -> parts[0],
                        Collectors.counting()
                ));
    }
    public static List<Map.Entry<String, Long>> topURLs(String filename) throws IOException {

        return Files.lines(Paths.get(filename))
                .map(line -> line.split(" "))
                .collect(Collectors.groupingBy(
                        parts -> parts[3],
                        Collectors.counting()
                ))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(3)
                .collect(Collectors.toList());
    }
    public static double error404Percentage(String filename) throws IOException {

        List<String> lines = Files.readAllLines(Paths.get(filename));

        long total = lines.size();

        long errors = lines.stream()
                .map(line -> line.split(" "))
                .filter(parts -> parts[2].equals("404"))
                .count();

        return (errors * 100.0) / total;
    }
}
