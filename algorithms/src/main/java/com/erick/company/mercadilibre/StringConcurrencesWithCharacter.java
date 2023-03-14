package com.erick.company.mercadilibre;

import java.awt.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StringConcurrencesWithCharacter {

    static String RepetedLetterMax(String s) {
        HashMap<Character, Integer> stringConcurrences = new HashMap<>();
        String fullChain = s.replace(" ", "").replace(",", "").toLowerCase();
        int lengthFullchain = fullChain.length();

        for (int i = 0; i < lengthFullchain - 1; i++) {
            char n = fullChain.charAt(i);
            if (stringConcurrences.containsKey(n)) {
                stringConcurrences.put(n, stringConcurrences.get(n) + 1);
            } else {
                stringConcurrences.put(n, 1);
            }
        }
        //stringConcurrences.entrySet().stream().forEach((k) -> System.out.println(k.getKey() + ":" + (k.getValue())));
        return stringConcurrences.entrySet()
                .stream()
                .max(Comparator.comparing(Map.Entry::getValue))
                .map(x -> "La letra que mas se repite es la " + String.valueOf(x.getKey()).toUpperCase() + " con " + x.getValue() + " repeticiones")
                .get();
    }


    public static void main(String[] args) {
        System.out.println(RepetedLetterMax("Hola, mi nombre es Ariel, soy una sirena, vivo bajo el mar"));
    }
}
