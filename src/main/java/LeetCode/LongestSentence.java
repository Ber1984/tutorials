package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LongestSentence {
    public static void main(String[] args) {
        System.out.println(longestSentence("We test coders. Give us a try? Hola. Hola como estas hoy mi hermosa!"));
    }

    private static int longestSentence(String S) {
        String words = "";

        List<String> wordList = new ArrayList<>();

        int i = 0;
        while (i < S.length()){
            words += S.charAt(i);
            if (S.charAt(i) == '.' || S.charAt(i) == '!' || S.charAt(i) == '?') {
                wordList.add(words);
                words = "";
                if(i == S.length() - 1){
                    break;
                } else {
                    if(S.charAt(i + 1) == ' '){
                        wordList.add(words);
                        words = "";
                        System.out.println("here");
                        i++;
                    }
                }
            }
            i++;
        }
        System.out.println("List" + wordList);

        int count = 1;
        int max = 0;

        for (int j = 0; j < wordList.size(); j++) {
            String word = wordList.get(j);
            for (int k = 0; k < word.length(); k++) {
                if (word.charAt(k) == ' ') {
                    count++;
                }
            }
            if (max < count) {
                max = count;
                count = 1;
            } else {
                count = 1;
            }
        }
        return max;
    }

}

