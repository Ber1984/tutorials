package com.erick.company.monads;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Monads {

    public static void main(String[] args) {
        String erick = Arrays.asList("Erick").stream()
                .map(String::toUpperCase) //Collect is an intermediate operator
                .collect(Collectors.joining()); //Collect is a terminal operator
    }
}
