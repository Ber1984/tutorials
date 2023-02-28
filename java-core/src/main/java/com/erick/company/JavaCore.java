package com.erick.company;

import java.util.ArrayList;
import java.util.List;

public class JavaCore {

    static List<List<String>> lists = List.of(
            List.of("mylist1", "mylist2")
    );
    public static void main(String[] args) {
        withFlatMap();
        int x = 5;
        int y = x++; //y = 5 y x = 6
        int z = ++x; // z = 7 y x = 7
        int result = x + y + z;
        System.out.println(result);
        int u;
        u = 10;
        {
            int l = 5;
            System.out.print(u + " " + l +" ");
        }
        int a = 'a';
        System.out.println(a);

        byte b = 5;
        b = (byte) (b + 5);

        List<String> obj = new ArrayList();
        obj.add("A");
        obj.add("B"); //D
        obj.add("C");
        obj.add(1, "D");
        System.out.println(obj);

        System.out.println("1804".substring(2));

        String s1 = "abc";
        String s2 = "def";
        String s3 = "abcdef";


    }
    public static void withFlatMap() {
        List<String> collectLists = lists.stream()
                .flatMap(List::stream)
                .toList();
        System.out.println(collectLists);
    }
}
