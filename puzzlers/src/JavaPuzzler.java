import netscape.javascript.JSObject;

import java.util.*;
import java.util.stream.Stream;

public class JavaPuzzler {

   public static void puzzle() {
       String[] stringArray = {"one", "two", "three"};
       new ArrayList<>();
       var stringsList = Arrays.asList(stringArray);

      int[] intArray = {1, 2 , 3};
      var intList = Arrays.asList(intArray);

       System.out.println(stringsList.contains("one") + " ,");
       System.out.println(intList.contains(1));

       Integer[] nums = {1 , 2 ,3};
       var integerList = Arrays.asList(nums);
       System.out.println(integerList.contains(1));
   }

   public static void puzzle1() {
       var ints = new ArrayList<>(List.of(1, 2, 3, 4, 5));
       //ints.add(1);
       List<Integer> integers = List.of(1, 2, 3, 4, 5);
       //integers.add(1); //throws UnsupportedOperationException because list is inmutable
       var subList = ints.subList(0, 0); // If fromIndex and toIndex are equal, the returned list is empty.)

       System.out.println(subList + " ");

       subList.addAll(List.of(10, 11, 12));

       var list2 = subList;
       System.out.println(ints);
       System.out.println(list2);

   }

   public static void puzzle2() {
       String[] ints = {"a", "b", "c", null};
       var strings1 = Stream.of(ints).toList();
       System.out.println(strings1.size());

       //List<String> strings = List.of("3", null);

       var string2 = List.of(ints);
       System.out.println(string2.size());
   }

   public static void puzzle3() {
       String[] inst = {"a", "b", "c", null};

       List<String> strings = Arrays.asList(inst);
       strings.removeIf(Objects::isNull);
       System.out.println(strings.size());
   }

   public static void puzzle4() {
       Map<Integer, String> map = new HashMap<>();
       map.put(4, null);

       System.out.println(map.getOrDefault(4, "four"));
       map.putIfAbsent(4, "four");

       //map.putIfAbsent(3, "three");
       System.out.println(map.get(4));

       map.forEach((k,v) -> System.out.println(k + v));
       System.out.println(map.size());

   }

   public static void puzzle5() {
       var numbers = List.of(-1, 0, 1);

       Map<Integer, List<Integer>> map = new HashMap<>();

       numbers.forEach(
               number -> map.putIfAbsent(number, new ArrayList<>())
                       .add(number));
       System.out.println(map.get(0));

   }

   public static void puzzle6() {
       Set<String> hashSet = new HashSet<>(List.of("a","b","c"));
       Set<String> treeSet = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);

       treeSet.addAll(List.of("A", "B", "C"));

       System.out.println(treeSet.equals(hashSet) + " ");
       System.out.println(hashSet.equals(treeSet));
   }

   public static void puzzle7() {
       var ints = List.of(1, 2, 3);
       var a = Arrays.asList(1, 2, 3);
       var c = Collections.unmodifiableCollection(ints);
       var l = Collections.unmodifiableList(ints);

       System.out.println(a.equals(c) + " ");
       System.out.println(a.equals(l) + " ");
       System.out.println(c.equals(l));

   }
    public static void main(String[] args) {
        //puzzle();
        puzzle7();

    }
}