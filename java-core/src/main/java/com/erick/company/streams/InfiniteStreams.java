package com.erick.company.streams;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class InfiniteStreams {
    public static void main(String[] args) {
        //infinite streams used to generate infinite stream of data
        List<Integer> collect = IntStream.iterate(1, n -> n + 1)
                .mapToObj(Integer::valueOf)
                .limit(100)
                .collect(Collectors.toList());
        //System.out.println(collect);

        //Random numbers -- 100
        List<Integer> generated = Stream.generate(() -> (new Random()).nextInt(100))
                .limit(10)
                .collect(Collectors.toList());
        System.out.println(generated);


    }
}
