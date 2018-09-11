/*
package com.javaperformarce;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Mode;

import java.util.stream.IntStream;


public class MyBenchmarks {
    */
/*
    BenchMarking Demo
    *//*

    @Benchmark
    @Fork(value = 1, warmups = 1)
    @BenchmarkMode(Mode.Throughput)
    public void givenOrderedStreamInput_whenStreamDistinct_thenShowOpsPerMS() {
        IntStream.range(1, 1_000_000).parallel().distinct().toArray();
    }

    @Benchmark
    @Fork(value = 1, warmups = 1)
    @BenchmarkMode(Mode.Throughput)
    public void givenUnorderedStreamInput_whenStreamDistinct_thenShowOpsPerMS() {
        IntStream.range(1, 1_000_000).unordered().parallel().distinct().toArray();
    }
}
*/
