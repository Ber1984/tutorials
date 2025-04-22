package com.erick.company.LeetCode;

public class CountSymmetricIntegers {
    public static void main(String[] args) {
        int ans = 0;
        for(int i = 1; i <= 100; i++) {
            if(i % 2 == 0 && i <= 10) {
                ans++;
            } else {
                if(i % 2 == 0) {
                    int mid = String.valueOf(i).length() / 2; //mid
                    String firstPart = String.valueOf(i).substring(0, mid);
                    String secondPart = String.valueOf(i).substring(mid);

                    for(int j = 0; j <firstPart.length();j++ ) { //12
                        int sum = 0, sum1 = 0;
                        sum += firstPart.charAt(i) - '0';
                        sum1 +=  secondPart.charAt(i) - '0';
                        if(sum != sum1) break;
                    }
                    ans++;

                }
            }


        }



    }
}
