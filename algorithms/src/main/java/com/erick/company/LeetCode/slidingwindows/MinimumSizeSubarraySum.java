package com.erick.company.LeetCode.slidingwindows;

public class MinimumSizeSubarraySum {

    /*
    in the shrinking process we're find others valid sub arrays ?


ChatGPT said:
Yes, exactly. In the shrinking process, we are effectively finding other valid subarrays and potentially identifying smaller subarrays that still meet the condition.

✅ Why Do We Find Other Valid Subarrays During the Shrinking Process?
When we detect that the current window sum is greater than or equal to the target, we enter the shrinking process. At this point, the current window is already a valid subarray.

However, by shrinking the window from the left, we are checking for smaller valid subarrays that might also meet the condition. This helps in minimizing the length of the subarray.

🔷 Example Analysis:
Problem:
Given nums = [2, 3, 1, 2, 4, 3] and target = 7.

Step-by-Step Walk-through:

Expand the Window:

end = 0: sum = 2 (Window: [2]) – Not valid

end = 1: sum = 5 (Window: [2, 3]) – Not valid

end = 2: sum = 6 (Window: [2, 3, 1]) – Not valid

end = 3: sum = 8 (Window: [2, 3, 1, 2]) – Valid subarray of length 4

Start Shrinking the Window:

Shrink once:

start = 1, sum = 6 (Window: [3, 1, 2]) – Not valid

Expand again:

end = 4: sum = 10 (Window: [3, 1, 2, 4]) – Valid subarray of length 4

Shrink again:

start = 2, sum = 7 (Window: [1, 2, 4]) – Valid subarray of length 3

start = 3, sum = 6 (Window: [2, 4]) – Not valid

Expand again:

end = 5: sum = 9 (Window: [2, 4, 3]) – Valid subarray of length 3

Shrink again:

start = 4, sum = 7 (Window: [4, 3]) – Valid subarray of length 2 (smallest valid subarray found)

✅ Why is This Process Efficient?
The window is only expanded and shrunk once per element, making the time complexity O(N).

Without the shrinking step, we would only detect the first valid subarray and miss potentially smaller valid subarrays.

✅ Implementation Analysis:
In the shrinking process, every time we find a valid subarray, we compare its length with the current minimum length:

while (sum >= target) {
    minLength = Math.min(minLength, end - start + 1);
    sum -= nums[start];
    start++;
}
This while loop allows us to evaluate multiple valid subarrays within the current window by continuously shrinking the window until sum < target.

This technique is a key component of the sliding window algorithm, allowing us to efficiently explore potential subarrays without unnecessary iterations.
     */
    public static void main(String[] args) {
        System.out.println(minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        //Sliding windows
        int start = 0, end = 0, minLength  = Integer.MAX_VALUE, sum = 0;

        while (end < nums.length) {
            // Expand the window by adding the current element
            sum += nums[end];
            // While the current window sum is greater than or equal to the target
            while (sum >= target) {
                // Calculate the length of the current window
                minLength = Math.min(minLength, end - start + 1);

                // Shrink the window from the left
                sum -= nums[start];
                start++;
            }
            // Move the right pointer to expand the window
            end++;
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;

    }
}
