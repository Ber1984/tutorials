package com.erick.company.algoritms;

import java.util.Arrays;
import java.util.Scanner;

public class SplitWords {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (true) {

            System.out.println();
            System.out.println("Enter your directions please");
            String direction = scanner.next();
            String[] directions = direction.split(" ");
            System.out.println(Arrays.toString(directions));
            String nextLocation = "";
            for (String direct : directions) {

            }

        }
    }
}
