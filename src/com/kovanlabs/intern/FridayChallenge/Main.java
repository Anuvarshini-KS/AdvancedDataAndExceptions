package com.kovanlabs.intern.FridayChallenge;

import java.util.Map;

public class Main {

    public static void main(String[] args) throws Exception {

        String file = "server.log";

        LogfileGenerator.generate(file, 10000);

        System.out.println("\nRequests per IP:");

        Map<String, Long> map = LogfileAnalyzer.requestsPerIP(file);

        map.entrySet()
                .stream()
                .limit(10)
                .forEach(System.out::println);

        System.out.println("\nTop 3 URLs:");

        LogfileAnalyzer.topURLs(file)
                .forEach(System.out::println);

        System.out.println("\n404 Error Percentage:");

        double percentage = LogfileAnalyzer.error404Percentage(file);

        System.out.println(percentage + "%");
    }
}
