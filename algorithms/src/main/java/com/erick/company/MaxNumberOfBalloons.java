package com.erick.company;

import java.util.HashMap;

public class MaxNumberOfBalloons {

    public static void main(String[] args) {
        System.out.println(maxNumberOfBalloons("loonbalxballpoon"));
    }

    public static int maxNumberOfBalloons(String text) {
                // Create a frequency map for the required characters
                HashMap<Character, Integer> map = new HashMap<>();
                map.put('b', 0);
                map.put('a', 0);
                map.put('l', 0);
                map.put('o', 0);
                map.put('n', 0);

                // Count frequencies of relevant characters in the input string
                for (int i = 0; i < text.length(); i++) {
                    char c = text.charAt(i);
                    if (map.containsKey(c)) {
                        map.put(c, map.get(c) + 1);
                    }
                }

                // Calculate the maximum number of "balloon" words
                // 'l' and 'o' need to be divided by 2
                int maxBalloons = Math.min(map.get('b'),
                        Math.min(map.get('a'),
                                Math.min(map.get('n'),
                                        Math.min(map.get('l') / 2,
                        map.get('o') / 2))));

                return maxBalloons;
            }

}
