package ru.job4j.gc;

import javax.management.*;
import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.Arrays;

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


    private static void defineGC () throws MalformedObjectNameException, MBeanException, InstanceNotFoundException, ReflectionException {
        Object flags = ManagementFactory.getPlatformMBeanServer().invoke(
                ObjectName.getInstance("com.sun.management:type=DiagnosticCommand"),
                "vmFlags", new Object[] { null }, new String[] { "[Ljava.lang.String;" });
        for(String f: ((String)flags).split("\\s+"))
            if(f.contains("GC")) System.out.println(f);
        for(GarbageCollectorMXBean gc: ManagementFactory.getGarbageCollectorMXBeans())
            System.out.printf("%-20s%s%n", gc.getName(), Arrays.toString(gc.getMemoryPoolNames()));
    }

    public static void main(String[] args) throws MalformedObjectNameException, MBeanException, InstanceNotFoundException, ReflectionException {
        defineGC();
        info();
        for (int i = 0; i < 4500; i++) {
            new User("N" + i, i);
        }
        //System.gc();
        info();
    }

}
