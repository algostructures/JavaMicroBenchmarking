package com.javaperformarce;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.TreeSet;
import java.util.stream.IntStream;
@State(Scope.Benchmark)
public class MapAndSet {




    @Benchmark
    @Fork(value = 1, warmups = 1)
    public void usingHashmap() {
        final int[] random = new Random().ints(1000000, 0, 100000).toArray();
        HashMap<Integer, Integer> integerHashMap = new HashMap<>();

        for(int i = 0; i < random.length; i++) {
            if(!integerHashMap.containsKey(random[i])) {
                integerHashMap.put( random[i], 1);
            }
        }
        int count = 0;
        for(int i = 0; i < 100000; i++) {
            if(integerHashMap.get(i) != null) {
                count++;
            }
        }
    }

    @Benchmark
    @Fork(value = 1, warmups = 1)
    public void usingHashSet() {
        final int[] random = new Random().ints(1000000, 0, 100000).toArray();
        HashSet<Integer> hashSet = new HashSet<>();

        for(int i = 0; i < random.length; i++) {
            hashSet.add(random[i]);
        }
        int count = 0;
        for(int i = 0; i < 100000; i++) {
            if(hashSet.contains(i)) {
                count++;
            }
        }
    }

    /*@Benchmark
    @Fork(value = 1, warmups = 1)
    public void usingTreeSet() {
        final int[] random = new Random().ints(1000000, 0, 100000).toArray();
        TreeSet<Integer> hashSet = new TreeSet<>();

        for(int i = 0; i < random.length; i++) {
            hashSet.add(random[i]);
        }
        int count = 0;
        for(int i = 0; i < 500000; i++) {
            if(hashSet.contains(i)) {
                count++;
            }
        }
    }*/

    /*@Benchmark
    @Fork(value = 1, warmups = 1)
    @BenchmarkMode(Mode.Throughput)
    public void usingBloomFilters() {
        final int[] random = new Random().ints(1000000, 0, 100000).toArray();
        BloomFilter<Integer> filter = BloomFilter.create(
                Funnels.integerFunnel(),
                1000000,
                0.001);

        for(int i = 0; i < random.length; i++) {
            filter.put(random[i]);
        }
        int count = 0;
        for(int i = 0; i < 500000; i++) {
            if(filter.mightContain(i)) {
                count++;
            }
        }
    }*/

    @Benchmark
    @Fork(value = 1, warmups = 1)
    @BenchmarkMode(Mode.Throughput)
    public void usingAIndexing() {
        final int[] random = new Random().ints(1000000, 0, 100000).toArray();
        boolean a[] = new boolean[100010];
        for(int i = 0; i < random.length; i++) {
            a[random[i]] = true;
        }
        int count = 0;
        for(int i = 0; i < 100000; i++) {
            if(a[i]) {
                count++;
            }
        }
    }
}
