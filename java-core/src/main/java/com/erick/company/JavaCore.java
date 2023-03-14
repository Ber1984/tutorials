package com.erick.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.IntStream;

public class JavaCore {

    static List<List<String>> lists = List.of(
            List.of("mylist1", "mylist2")
    );

    static long value1 = 10;
    public static void main(String[] args) {
        withFlatMap();
        int x = 5;
        int y = x++; //y = 5 y x = 6
        int z = ++x; // z = 7 y x = 7
        int result = x + y + z;
        //System.out.println(result);
        int u;
        u = 10;
        {
            int l = 5;
            //System.out.print(u + " " + l +" ");
        }
        int a = 'a';
        //System.out.println(a);

        byte b = 5;
        b = (byte) (b + 5);

        List<String> obj = new ArrayList();
        obj.add("A");
        obj.add("B"); //D
        obj.add("C");
        obj.add(1, "D");
        //System.out.println(obj);

        //System.out.println("1804".substring(2));

        String s1 = "abc";
        String s2 = "def";
        String s3 = "abcdef";

    test();
        moveIntegers();
    }
    public static void withFlatMap() {
        List<String> collectLists = lists.stream()
                .flatMap(List::stream)
                .toList();
        //System.out.println(collectLists);
    }

    static void test() {
        var value2 = new AtomicLong(0);
        final long[] value3 = {0};
        final long[] value4 = {0};
        //IntStream.range(1, 100).forEach(System.out::println);
        IntStream.range(1, 100).parallel().forEach(a -> value1++);
        System.out.println(value1);//1
        IntStream.range(1, 100).parallel().forEach(a -> value2.incrementAndGet());
        System.out.println(value2);//2
        IntStream.range(1, 100).parallel().forEach(a -> value3[0]++);
        System.out.println(value3[0]);//3
        IntStream.range(1, 100).parallel().forEach(a -> value4[0] = incrementAndGet(value4[0]));
        System.out.println(value4[0]);//4
    }

    private static synchronized Long incrementAndGet(Long number) {
        return ++number;
    }

    static void moveIntegers() {
        int[] array = {1,2,2,2,3,4,5};  //2
        //order the array Arrays.sort();

        int i = 0,j = array.length;
        while(i < j) {
            if(array[i] == 2 && array[j] != 2) {
                int number = array[i];
                int swap = array[j];
                array[j] = number;
                array[i] = swap;
            }
            i++; j--;
        }
        System.out.println(Arrays.toString(array));
    }
}
