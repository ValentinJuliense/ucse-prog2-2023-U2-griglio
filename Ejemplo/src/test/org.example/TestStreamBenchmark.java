package org.example;

import org.openjdk.jmh.annotations.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class TestStreamBenchmark {
    private List<Integer> list;

    @Setup
    public void setup() {
        int size = 10000000;
        Random random = new Random();
        list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(random.nextInt(50000));
        }
    }

    @Benchmark
    public List<Integer> testStream() {
        return list.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
    }

    @Benchmark
    public List<Integer> testParallelStream() {
        return list.parallelStream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
    }
}