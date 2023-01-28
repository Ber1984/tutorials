package algoritms.com.erick.algoritms.AlgoCademy;

public class maxSumSubarray {
    public static  void main(String[] args) {
        int[] myArray = {-2, -5, 6, -2, -3, 1, 5, -6};
        int max = maxSumSubarray(myArray);
        System.out.println(max);
    }

    public static  int maxSumSubarray(int[] nums) {
        int maxSum = nums[0];
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }
}
