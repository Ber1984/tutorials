package com.erick.company.algoritms;

import java.util.*;

public class CountLargestGroup {

    public static void main(String[] args) {
        System.out.println(countLargestGroup(264));

    }

    public static int countLargestGroup(int n) {
        int max = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            int currentSum = 0, num = i;
            while (num > 0) {
                currentSum += num % 10;
                num /= 10;
            }

            if (map.containsKey(currentSum)) {
                map.get(currentSum).add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(currentSum, list);
            }
        }

        for (List<Integer> list : map.values()) {
            max = Math.max(max, list.size());
        }

        int ans = 0;
        for (Map.Entry<Integer, List<Integer>> item : map.entrySet()) {
            if (item.getValue().size() == max) {
                ans++;
            }
        }

        return ans;
    }

    /*
        while(num > 0) {
        ans += num % 10;
        num /= 10;
     */

    /*
     Line-by-line breakdown:
1. num % 10
This gives you the last digit of the number.

If num = 123, then 123 % 10 = 3

2. currentSum += num % 10
You add that last digit to the running total currentSum.

3. num /= 10
This does integer division by 10, which removes the last digit.

123 / 10 = 12

12 / 10 = 1

1 / 10 = 0 → loop ends

So over the course of the loop:

num = 123, currentSum = 0

→ add 3, now currentSum = 3

num = 12, → add 2, now currentSum = 5

num = 1, → add 1, now currentSum = 6

num = 0 → done!

int num = 409;
409 % 10 = 9, sum = 9, then 409 / 10 = 40
40 % 10 = 0, sum = 9, then 40 / 10 = 4
4 % 10 = 4, sum = 13, then 4 / 10 = 0 → done!
     */

}
