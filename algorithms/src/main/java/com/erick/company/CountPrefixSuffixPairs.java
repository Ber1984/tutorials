package com.erick.company;

public class CountPrefixSuffixPairs {
    public static void main(String[] args) {
        System.out.println(countPrefixSuffixPairs2(new String[]{"a","aba","ababa","aa"}));
    }

    public static int countPrefixSuffixPairs(String[] words) {
        int ans = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                if(isPrefixAndSuffix(words[i], words[j])) {
                    ans++;
                }
            }
        }

        return ans;

    }

    private static boolean isPrefixAndSuffix(String str1, String str2) {
        if(str2.startsWith(str1) && str2.endsWith(str1)) {
            return true;
        }
        return false;
    }

    //recursion version

    public static int countPrefixSuffixPairs2(String[] words) {

        return isPrefixAndSuffix2(words, 0, 1);

    }



    private static int isPrefixAndSuffix2(String[] words, int i, int j) {
        if (i >= words.length - 1) {
            // Terminate recursion when all words are checked
            return 0;
        }

        if (j >= words.length) {
            // Move to the next word as `i` when `j` exceeds the array length
            return isPrefixAndSuffix2(words, i + 1, i + 2);
        }

        int count = 0;
        if (words[j].startsWith(words[i]) && words[j].endsWith(words[i])) {
            count = 1;
        }

        // Continue to the next pair
        return count + isPrefixAndSuffix2(words, i, j + 1);
    }
}
