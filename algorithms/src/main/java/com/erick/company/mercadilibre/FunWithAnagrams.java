package com.erick.company.mercadilibre;

import java.util.*;
import java.util.stream.Collectors;

public class FunWithAnagrams {

    public static List<String> funWithAnagrams(List<String> words) {
        List<String> ans = new LinkedList<String>();
        Set<String> found = new HashSet<String>();

        String s = words.stream().map(Objects::toString)
                .collect(Collectors.joining());
        for (int i = 0; i < words.size(); i++) {
            String word = words.get(i);
            String key = key(word);
            if (!found.contains(key)) {
                ans.add(word);
                found.add(key);
            }
        }
        Collections.sort(ans);

        return ans;
    }

    public static String key(String word) {
        char[] chrs = word.toCharArray();
        Arrays.sort(chrs);
        return new String(chrs);
    }

    public static void main(String[] args) {
        List<String> a = Arrays.asList("code", "aaagmnrs", "anagrams", "doce");
        System.out.println(funWithAnagrams(a));
    }
}
