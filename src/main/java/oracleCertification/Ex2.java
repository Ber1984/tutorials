package oracleCertification;

import java.util.Arrays;

public class Ex2 {

    public static void main(String[] args) {
        int a[] = {1,2,053,4};
        System.out.println(Arrays.toString(a));
        int b[][] = { {1,2,4},{2,2,1},{0,43,2} };
        System.out.println(a[3] == b[0][2]);
        System.out.println((a[2]) == b[2][1]);
        System.out.println(a[2]);
        System.out.println(b[2][1]);
    }

}
