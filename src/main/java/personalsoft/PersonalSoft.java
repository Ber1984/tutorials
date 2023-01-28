package personalsoft;

import java.util.Arrays;

public class PersonalSoft {
    public static void main(String[] args) {

        int[] a = {1, 1, 1, -5};
        int sum = 0;
        int[] b = new int[a.length];
        int j = a.length;
        for (int i = 0; i < a.length; i++) {
            b[j - 1] = a[i];
            j = j - 1;
        }


        for (int i = 0; i <b.length ; i++) {
            if(i <= 3){
               sum+=b[i];
            }
        }

        System.out.println(Arrays.toString(b));
        System.out.println(sum);

    }
}
