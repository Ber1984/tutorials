package com.erick.company.LeetCode;

class IsPalindrome {
    public static void main(String[] args) {
        boolean result = isPalindrome("RacE___$_ a .car@");

        System.out.println(result);
    }

    public static boolean isPalindrome(String s) {
        StringBuilder strBuilder = new StringBuilder();
        String strWithoutSpaces = s.toLowerCase().replaceAll("[\\W_.]", "");
        System.out.println(strWithoutSpaces);

        strBuilder.append(strWithoutSpaces);
        String reverseStr = strBuilder.reverse().toString();
        System.out.println(strBuilder);

        if (strWithoutSpaces.equals(reverseStr)) {
            System.out.println("here");
            return true;
        }
        return false;

    }



    //Second solution
    /*
     private static boolean isPalindrome(String s){
         String fixed_string = "";
         for(char c : s.toCharArray()){
             if(Character.isLetterOrDigit(c)){
                 fixed_string += c;
             }
         }

         fixed_string = fixed_string.toLowerCase();
         int a_pointer = 0;
         int b_pointer = fixed_string.length() - 1;

         while (a_pointer <= b_pointer){
             if(fixed_string.charAt(a_pointer) != fixed_string.charAt(b_pointer)){
                 return false;
             }
             a_pointer++; //a_pointer += 1;
             b_pointer--; //b_pointer -= 1;
         }

         System.out.println(fixed_string);
         return true;
     }

     */

    //Third solution
    /*
    private static boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        s = s.toLowerCase();
        while (i < j) {
            char c = s.charAt(i), d = s.charAt(j);
            if (!isAlphanumeric(c)) {
                i++;
                continue;
            }
            if (!isAlphanumeric(d)) {
                j--;
                continue;
            }
            if (c != d) return false;
            i++;
            j--;
        }
        return true;
    }

    private static boolean isAlphanumeric(char c) {
        return Character.isLetter(c) || Character.isDigit(c);
    }

     */


}
