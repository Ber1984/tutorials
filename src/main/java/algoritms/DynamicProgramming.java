package algoritms;

public class DynamicProgramming {

    public static void main(String[] args) {
        /*
        //It's a way of making the algorithm more efficient by
        storing som of intermediate result
        concurrent example
        it work really well when the algorithm has a lot of repetitive computations
        you don't have to repeat those computations over and over again
        Solutions =
        1. Recursion
        2. Store (Memorize) store repeated computations

        */


    }

    static int bruteForce(int n) {
        int result = 0;
        if(n == 1 || n == 2) {
            result = 1;
        } else {
            result = bruteForce(n - 1) + bruteForce(n - 1);
        }
        return result;
    }
    /*
    static int memoizedSolution (int n, int[] memo) {
        memo = new int[n + 1];
       int result  = 0;
       if (memo[n] != null) return memo[n];
       if(n == 1 || n == 2) result = 1;
       else {
           result = memoizedSolution()
       }
    }

     */


    static int fibBottomUpApproach(int n) {
        if (n == 1 || n == 2) return 1;
        int[] bottomUp = new int[n + 1];
        bottomUp[1] = 1;
        bottomUp[2] = 1;

        for(int i = 3;i<n;i++) {
            bottomUp[i] = bottomUp[i - 1] + bottomUp[i - 2];
        }
        return bottomUp[n];
    }
}
