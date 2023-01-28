package algoritms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SimetricArray {

    static String[] myArray = {"a", "b", "c", "d", "d", "c", "b", "a"};
    //static String[] myArray = {"a","c","c","d","b","d","b","a"};
    static int n = 8;
    static List<String> finalList = new ArrayList<>();
    static List<String> aux = new ArrayList<>();
    static List<String> reverseOrder = new ArrayList<>();

    static String[] listToString(String[] myArray ){
        int myArrayLength = myArray.length;

        for (int i = 0; i <myArrayLength ; i++) {
            String current =  myArray[i];
            //System.out.println("current" + current);
            for (int j = i + 1; j <myArrayLength; j++) {
                if(current.equals(myArray[j])){
                    aux.add(current);
                    System.out.println(aux);
                    break;
                }
            }
        }

        for (int i = aux.size() - 1; i >= 0 ; i--) {
            reverseOrder.add(aux.get(i));
        }

        finalList.addAll(aux);
        finalList.addAll(reverseOrder);

        String[] finalResult =  finalList.toArray(String[]::new);

        if(Arrays.equals(finalResult,myArray)){
            System.out.println("Symmetric");
        } else {
            System.out.println("Asymmetric");
        }
        return null;
    }


    public static void main(String[] args) {
        listToString(myArray);
        List reversedOne = (List) Arrays.stream(myArray).sorted(Comparator.reverseOrder()).distinct().collect(Collectors.toList());
        //List reversedOne = (List) numbers.stream().sorted(Comparator.reverseOrder())
                //.collect(Collectors.toList());

        /*
        List numbers = Arrays.asList(myArray);


        numbers = (List) numbers.stream().distinct().sorted().collect(Collectors.toList());
        System.out.println("myNumber" + numbers);
        List reversedOne = (List) Arrays.stream(myArray).sorted(Comparator.reverseOrder()).distinct().collect(Collectors.toList());
        List reversedOne = (List) numbers.stream().sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
        System.out.println("rever" + reversedOne);
        List<String> newList = (List<String>) Stream.concat(numbers.stream(),
                reversedOne.stream()).collect(Collectors.toList());
        //newList.forEach(System.out::println);

        String[] newArray = newList.toArray(String[]::new);
        System.out.println("new array" + Arrays.toString(newArray));
        System.out.println("default" + Arrays.toString(myArray));

        if (Arrays.equals(newArray,myArray)) {
            System.out.println("Symmetric");
        } else {
            System.out.println("Asymmetric");
        }

 */

    }
}
