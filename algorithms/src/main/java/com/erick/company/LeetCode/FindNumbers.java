package com.erick.company.LeetCode;

public class FindNumbers {
    public static void main(String[] args) {

    }


    /*
    1. JVM Optimization Differences (HotSpot JIT)
The JVM (HotSpot JIT compiler) can sometimes optimize != 0 faster than > 0 because it's a single comparison directly checking against zero.

> 0 involves checking a signed condition, which can be marginally slower or more complex at the assembly level (especially if sign flags are involved).

In contrast, != 0 is often optimized into a simple test or cmp CPU instruction with a jne jump, which is very cheap.

🧠 2. Branch Prediction (CPU-Level)
At the CPU level, != 0 can be more predictable and uniform in branch prediction patterns — especially in tight loops with simple conditions.

This can lead to:

Fewer branch mispredictions

Better CPU pipeline performance

🔬 3. Microbenchmark Artifacts
If you’re testing performance using a small benchmark, improvements might be due to:

CPU caching effects

Code layout alignment

JIT warmup phase differences

These don’t always reflect real-world application behavior, but they do show that != 0 might give slightly faster low-level execution.

✅ Bottom Line
Yes, for positive integers, both num > 0 and num != 0 work the same.
However, num != 0 might give better performance due to:

Simpler CPU instructions

Better JVM optimizations

Faster branch prediction

It’s a micro-optimization — not critical, but good to know if you're writing performance-sensitive code like in competitive programming, real-time systems, or tight loops.

     */
    public int findNumbers(int[] nums) {
        int ans = 0;

        for (int num : nums) {
            int numberOfDigits = 0;

            while (num != 0) {
                num = num / 10;
                numberOfDigits++;
            }

            if (numberOfDigits % 2 == 0) {
                ans++;
            }
        }

        return ans;
    }

}
