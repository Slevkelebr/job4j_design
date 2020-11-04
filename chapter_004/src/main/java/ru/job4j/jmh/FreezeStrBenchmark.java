package ru.job4j.jmh;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

@BenchmarkMode(Mode.AverageTime) //Режим работы
@OutputTimeUnit(TimeUnit.MICROSECONDS) //Вывод результата в ед.измерениях
@State(Scope.Benchmark) //Данные хранятся в одном потоке
@Warmup(iterations = 3) // этап прогрева VM
@Measurement(iterations = 3) // этап измерений
@Fork(value = 2) // кол-во повторов этапов

public class FreezeStrBenchmark {

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(FreezeStr.class.getSimpleName())
                .build();
        new Runner(opt).run();
    }

    @State(Scope.Benchmark)
    public static class MyState {
        String left = "Hello";
        String right = " Hlloa";
    }

    @Benchmark
    public static boolean testEqSort(MyState state) {
        boolean rsl = true;
        if (state.left.length() != state.right.length()) {
            return false;
        }
        char[] ch1 = state.left.toCharArray();
        char[] ch2 = state.right.toCharArray();
        Arrays.sort(ch1);
        Arrays.sort(ch2);
        for (int i = 0; i < ch1.length; i++) {
            if (ch1[i] != ch2[i]) {
                rsl = false;
            }
        }
        return rsl;
    }

    @Benchmark
    public static boolean testEqCheckChar(MyState state) {
        int[] letters = new int[256];
        char[] leftArray = state.left.toCharArray();
        for (char c : leftArray) {
            letters[c]++;
        }
        for (int i = 0; i < state.right.length(); i++) {
            int c = state.right.charAt(i);
            if (--letters[c] < 0) {
                return false;
            }
        }
        return true;
    }
}
