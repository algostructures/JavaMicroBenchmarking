package com.javaperformarce;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Mode;

import java.util.stream.IntStream;

public class StringBenchMarks {




    @Benchmark
    @Fork(value = 1, warmups = 1)
    @BenchmarkMode(Mode.Throughput)
    public void usingStringConcatenation() {
        String s = "";
        for(int i = 0; i < 1_000_00; i++)
            s+="temp";
    }

    @Benchmark
    @Fork(value = 1, warmups = 1)
    @BenchmarkMode(Mode.Throughput)
    public void usingStringBuilderConcatenation() {
        StringBuilder s= new StringBuilder();
        for(int i = 0; i < 1_000_00; i++)
            s.append("temp");
    }

    @Benchmark
    @Fork(value = 1, warmups = 1)
    @BenchmarkMode(Mode.Throughput)
    public void usingStringBufferConcatenation() {
        StringBuffer s= new StringBuffer();
        for(int i = 0; i < 1_000_00; i++)
            s.append("temp");
    }
}
