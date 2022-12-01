import java.util.HashSet;
import java.util.Set;

public class MinimizeTheDifference {
    public static void main(String[] args) {
        minimizeTheDifference(new int[][]{{1,2,3},{4,5,6},{7,8,9}}, 13);
    }
    public static int minimizeTheDifference(int[][] mat, int target) {
        Set<Integer> curSet = new HashSet<>();
        curSet.add(0);

        for (int[] row : mat) {
            Set<Integer> newSet = new HashSet<>();
            int minOverTarget = -1;

            for (int v : curSet) {
                for (int n : row) {
                    if (v + n >= target) {
                        if (minOverTarget == -1)
                            minOverTarget = v + n;
                        if (v + n <= minOverTarget)
                            newSet.add(v + n);
                    } else
                        newSet.add(v + n);
                }
            }

            curSet = newSet;
        }

        int min_diff = Integer.MAX_VALUE;
        for (Integer v : curSet) {
            int curr_diff = Math.abs(v - target);
            min_diff = Math.min(curr_diff, min_diff);
        }
        return min_diff;
    }
}
