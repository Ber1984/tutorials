package com.erick.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordSubsets {
    private static int sumSize;
    public static void main(String[] args) {
        System.out.println(wordSubsets(new String[]{"amazon","apple","facebook","google","leetcode"}, new String[]{"e","o"}));
    }

    public static List<String> wordSubsets(String[] words1, String[] words2) {
        ArrayList<String> answers = new ArrayList();

        Map<Character, Integer> words1Map = new HashMap();
        Map<Character, Integer> words2Map = new HashMap();
        boolean[] tmp = new boolean[words2.length];
        int count = 0;
        for (String word : words1) {
            for (char ch : word.toCharArray())
                words1Map.put(ch, words1Map.getOrDefault(ch, 0) + 1);
            for(String word2 : words2) {
                sumSize =  word2.length();
                words2Map.clear();
                    for (char ch : word2.toCharArray()) {
                        words2Map.put(ch, words2Map.getOrDefault(ch, 0) + 1);
                    }
                    for(Map.Entry<Character, Integer> item : words2Map.entrySet()) {
                        if(words1Map.containsKey(item.getKey()) && item.getValue() <= words1Map.get(item.getKey())) {
                            System.out.println("no content");
                            count++;
                        }
                    }
            }

            if(count == sumSize) {
                answers.add(word);
            }

            words1Map.clear();

        }
        return answers;
    }
}
