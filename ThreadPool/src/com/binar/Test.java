package com.binar;

import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {

    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_YELLOW = "\u001b[0m";

    public static void main(String[] args) throws InterruptedException {
        Map<Integer, List<String>> stateNumCitiesMap = new LinkedHashMap<>();

        for (int i = 0; i < 100; i++) {
            stateNumCitiesMap.put(i, Collections.singletonList("ABC"));
        }
        ExecutorService executor = Executors.newFixedThreadPool(3);


        List<Callable<Void>> jobs = new ArrayList<>();
        for (Integer key : stateNumCitiesMap.keySet()) {
            jobs.add(() -> {
                writeCitiesOfStateToFile(key, stateNumCitiesMap.get(key));
                return null;
            });
        }
        long startTime = System.nanoTime();
        executor.invokeAll(jobs);
        long endTime   = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println("Total time : " + totalTime/1000 + " ms ");
        executor.shutdown();
    }

    public static void writeCitiesOfStateToFile(int stateNum, List<String> citiesList) {
        for (String city : citiesList) {
            String color = "";
            if (Thread.currentThread().getName().equals("pool-1-thread-1")){
                color = ANSI_BLUE;
            }else if (Thread.currentThread().getName().equals("pool-1-thread-2")){
                color = ANSI_YELLOW;
            }else {
                color = ANSI_GREEN;
            };
            System.out.println(color+"data : " + stateNum + " thread ke : " +  Thread.currentThread().getName());
        }
    }
}
