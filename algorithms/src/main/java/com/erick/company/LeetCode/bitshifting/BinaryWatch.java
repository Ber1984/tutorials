package com.erick.company.LeetCode.bitshifting;

import java.util.ArrayList;
import java.util.List;

public class BinaryWatch {

    public static void main(String[] args) {
        System.out.println(binaryWatchBacktracking(1));
    }

    /*
    Breakdown
    Loop through all possible times (12 hours × 60 minutes = 720 combinations).
     For each combination, count the bits (number of LEDs on).

If the total number of 1s in binary representation of hour and minute equals turnedOn, it’s a valid time.

Add it to the result list using proper formatting.
     */


    /*
    Let's say turnedOn = 1.

You are looking for all times where the total number of 1s in the binary representation of the hour and minute equals 1.

Let's check a few:
1:00 → hour = 1 → 0001, minute = 0 → 000000

1 one in total → ✅ valid

0:01 → hour = 0 → 0000, minute = 1 → 000001

1 one in total → ✅ valid

2:00 → hour = 2 → 0010, minute = 0 → 000000

1 one in total → ✅ valid

So for turnedOn = 1, the result would include:

"1:00"

"2:00"

"4:00"

"8:00"

"0:01"

"0:02"

"0:04"

"0:08"

"0:16"

"0:32"

Each of those has only one bit set to 1.
     */
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> result = new ArrayList<>();

        for (int hour = 0; hour < 12; hour++) {
            for (int minute = 0; minute < 60; minute++) {
                //You are looking for all times where the total number of 1s in the binary representation of the hour and minute equals 1.

                /*
                1:00 → hour = 1 → 0001, minute = 0 → 000000
                1 one in total → ✅ valid
                 */

                int bits = Integer.bitCount(hour) + Integer.bitCount(minute);
                if (bits == turnedOn) {
                    result.add(String.format("%d:%02d", hour, minute));
                    //we format like this %d = Format an integer as a decimal number
                    //: normal colon
                    //%02d = Format an integer as a decimal number but ensure it's a least 2 digits long
                    //if the number is not long i'll added 0
                    //If the number is only 1 digit, it adds a leading 0 to make it 2 digits.
                    //String.format("%02d", 5);
                    //String.format("%02d", 12);
                }
            }
        }

        return result;


        //Time complexity
        /*
        You're looping:

        12 times for hour (0 to 11)
        60 times for minute (0 to 59)
        So the total iterations = 12 × 60 = 720 → this is constant.
        That means:

Time Complexity = O(1) (constant time), because the search space is fixed and does not grow with input.

Even if you nested two loops, they are bounded by constant ranges (12 and 60), so you are not doing O(n²).

💡 Even Integer.bitCount() is a constant-time operation (since it operates on a 32-bit integer max).
         */
        //Space complexity 0(n)
        /*
        You're right here:

You're using only a list of results, which depends on how many valid combinations you find (at most 720).

No recursive stack or dynamic memory growth.
Space Complexity = O(1) extra space (not counting output), or O(k) where k is the number of valid results returned (bounded by 720).
         */
    }

    //Recursion
    private static List<String> binaryWatchBacktracking(int turnedOn) {
        var ans = new ArrayList<String>();

        backtrack(turnedOn, ans, 0, 0);
        return ans;


    }

    private static void backtrack(int turnedOn, List<String> ans, int hour, int minutes) {
        if(hour > 12) return;
        if(turnedOn == Integer.bitCount(hour) + Integer.bitCount(minutes)) {
            ans.add(String.format("%d:%02d", hour, minutes));
        }
        if(minutes <= 60) {
            backtrack(turnedOn, ans, hour, minutes + 1);
        } else {
            backtrack(turnedOn, ans, hour + 1, 0);
        }

    }

    //backtracking

    public List<String> readBinaryWatchBacktracking(int num) {
        List<String> result = new ArrayList<>();
        backtrack(result, num, 0, 0, 0);
        return result;
    }

    private void backtrack(List<String> result, int ledsLeft, int index, int hour, int minute) {
        // Invalid time → prune
        if (hour > 11 || minute > 59) return;

        // Base case: no more LEDs to turn on
        if (ledsLeft == 0) {
            result.add(String.format("%d:%02d", hour, minute));
            return;
        }

        // Try each bit from current index to 9
        for (int i = index; i < 10; i++) {
            if (i < 4) {
                // Bits 0-3 → Hour LEDs (bit value = 1 << i)
                backtrack(result, ledsLeft - 1, i + 1, hour + (1 << i), minute);
            } else {
                // Bits 4-9 → Minute LEDs (bit value = 1 << (i - 4))
                backtrack(result, ledsLeft - 1, i + 1, hour, minute + (1 << (i - 4)));
            }
        }
    }

}
