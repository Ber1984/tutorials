package com.erick.company.LeetCode;

public class LengthAfterTransformations {

    public static void main(String[] args) {
        System.out.println(lengthAfterTransformations("abcyy", 2));
        System.out.println(lengthAfterTransformations("azbk", 1));
    }

    public static int lengthAfterTransformations(String s, int t) {
        //100.000
        //count ans according to this i'm going to change the values
        int[] cnt = new int[26]; //create a fix array to count the chars
        int MOD = 1000000007; //module of 7
        for (char ch : s.toCharArray()) {
            ++cnt[ch - 'a']; //get the current value of that index and  increment.
        }

        for (int round = 0; round < t; ++round) { //iterate until reach T
            int[] nxt = new int[26]; //create a new array to store the value shifted to the right.
            nxt[0] = cnt[25]; //updating the value of z in a and b because we need to add ab when we find ab
            nxt[1] = (cnt[25] + cnt[0]) % MOD; //The logic is that 'a' can be converted to 'b', and 'z' can also be converted to 'b' because after 'z', we cycle back to 'a' and 'b'.
            for (int i = 2; i < 26; ++i) {
                nxt[i] = cnt[i - 1]; //updating the value from cnt to nxt
            }
            cnt = nxt; //asignining next array with new counters to cnt
        }

        /*
        The % MOD operation ensures that the count stays within the limits of a typical integer size and prevents overflow. This is a common technique in competitive programming to avoid overflow in large numbers.
         */
        int ans = 0;
        for (int i = 0; i < 26; ++i) {
            ans = (ans + cnt[i]) % MOD;
        }
        return ans;

    }
}
