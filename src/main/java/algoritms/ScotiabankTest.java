package algoritms;

import java.util.stream.IntStream;

public class ScotiabankTest {
    private String message;

    public static void main(String[] args) {

        /*
        Integer[] A = {-1, -2 , -2 , 4, 1, 2, 500, 1000000};
        Integer[] array = Stream.of(A).toArray(Integer[]::new);
        //Arrays.sort(A);
        //Arrays.asList(A);

        //System.out.println(Arrays.toString(A));
        //Arrays.stream(A).parallel().filter(n -> n >= 0).sorted().limit(1).forEach(System.out::println);
        int result = Arrays.stream(array).parallel().filter(n -> n >= 0).sorted().mapToInt(n -> n.intValue()).min().getAsInt();
        System.out.println(result);
        //IntStream result  =  Arrays.stream(A).parallel().filter(n -> n >= 0).sorted().limit(1).mapToInt(Integer::intValue);

        //System.out.println(result);

         */
        //IntStream.rangeClosed(1,100000).forEach(System.out::println);
        int n = 7;

        int sqrt  = (int) Math.sqrt(n);

        long count = IntStream.rangeClosed(1, sqrt).parallel().filter(num -> n % num == 0).count();
        String message = (count == 2) ? "Prime" : "Not prime";
        System.out.println(count);

    }
    /*
    static Predicate<Boolean> myFunction(int n ){
        int  i = 1;
        if(n % i == 0){
            return true;
        }
        return false;
    }

     */


}
