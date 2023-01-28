package LeetCode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams {
    public static void main(String[] args) {

    }

    private static List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> groupedAnagrams = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();

        for (String current : strs) {
            char[] characters = current.toCharArray();
            Arrays.sort(characters);
            String sorted = new String(characters);

            if (!map.containsKey(sorted)) {
                map.put(sorted, new ArrayList<>());
            }
            map.get(sorted).add(current);
        }

        groupedAnagrams.addAll(map.values());
        System.out.println(groupedAnagrams.get(2).get(1));
        return groupedAnagrams;
    }
}
