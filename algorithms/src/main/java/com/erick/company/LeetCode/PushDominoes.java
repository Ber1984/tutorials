package com.erick.company.LeetCode;

public class PushDominoes {

    public static void main(String[] args) {
        System.out.println(pushDominoes(".L.R...LR..L.."));
        System.out.println(pushDominoes("RR.L"));
    }

    public static String pushDominoes(String dominoes) {
        int n = dominoes.length();
        char[] arr = dominoes.toCharArray(); //to access in constant time because charAt() creates an internal lookup.
        int[] forces = new int[n];

        int force = 0;
        // Left to right pass
        for (int i = 0; i < n; i++) {
            if (arr[i] == 'R') {
                force = n;
            } else if (arr[i] == 'L') {
                force = 0;
            } else {
                force = Math.max(force - 1, 0);
            }
            forces[i] += force;
        }

        // Right to left pass
        force = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] == 'L') {
                force = n;
            } else if (arr[i] == 'R') {
                force = 0;
            } else {
                force = Math.max(force - 1, 0);
            }
            forces[i] -= force;
        }

        // Build result
        StringBuilder result = new StringBuilder();
        for (int f : forces) {
            if (f > 0) result.append('R');
            else if (f < 0) result.append('L');
            else result.append('.');
        }

        return result.toString();
    }

    /*
    ✅ Time Complexity: O(n)
First pass (left to right): processes each character once → O(n)

Second pass (right to left): again, each character once → O(n)

Final pass (build result): iterate once more to construct the final string → O(n)

So overall:

O(n)+O(n)+O(n)=O(n)

Space Complexity: O(n)
forces[] array of size n → O(n)

char[] arr = dominoes.toCharArray() → technically this duplicates the input → O(n)

StringBuilder to construct the final result → up to n characters → O(n)

Hence, space complexity is also O(n).
     */

}
