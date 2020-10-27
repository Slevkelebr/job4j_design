package ru.job4j.gc;

import javax.management.*;

public class TestGC {
    private static final Runtime ENVIRONMENT = Runtime.getRuntime();


    public static void info() {
        final long freeMemory = ENVIRONMENT.freeMemory();
        final long totalMemory = ENVIRONMENT.totalMemory();
        final long maxMemory = ENVIRONMENT.maxMemory();
        System.out.println("=== Environment state ===");
        System.out.printf("Free: ================ %d%n", freeMemory);
        System.out.printf("Total: %d%n", totalMemory);
        System.out.printf("Max: %d%n", maxMemory);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 25000; i++) {
            new User("N" + i, i);
        }
    }


}
