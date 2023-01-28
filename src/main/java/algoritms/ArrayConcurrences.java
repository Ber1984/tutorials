package algoritms;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class ArrayConcurrences {
    static int[] myArray = {1, 2, 1, 3, 3, 1, 2, 1, 5, 1};

    private static String convertToStars (int num){
        StringBuilder stars = new StringBuilder();
        for(int j = 0;j<num;j++){
            stars.append('*');
        }
        return stars.toString();
    }

    public static void main(String[] args) {

        HashMap<Integer, Integer> aux = new HashMap<>();
        int myArrayLength = myArray.length;
        Arrays.sort(myArray);
        int[] aux2 = new int[myArrayLength];
        String[] aux3 = new String[1];
        int count = 1;
        int pos = 0;

        /*
        System.out.println(Arrays.toString(myArray));
        for (int i = 0; i < myArrayLength - 1; i++) {
             int current =   myArray[i];
            System.out.println(current + " pos " +  myArray[i + 1]);
            if(current == myArray[i + 1] ){
                System.out.println("here");
                count++;
                System.out.println("count" + count);
            } else {
                aux2[pos] = count;
                System.out.println("dento de else " + Arrays.toString(aux2));
                count = 1;
                aux2[pos + 1] = count;
                pos = pos + 1;
                System.out.println("dento de else new aux " + Arrays.toString(aux2));
            }

        }

        System.out.println(Arrays.toString(aux2));
        String strArray[] =  Arrays.stream(aux2)
                .mapToObj(String::valueOf)
                .map(x -> x.replace(x,"*"))
                .toArray(String[]::new);
        System.out.println(Arrays.toString(strArray));

         */

        int missingValue = 0;
        int maxNumber = myArray[myArrayLength - 1];
        //System.out.println(maxNumber);
        for (int i = 0; i <maxNumber; i++) {
            int current = myArray[i];
            if(current != myArray[i + 1]){
                missingValue = i;
            }
        }
        //System.out.println(Arrays.toString(myArray));
        for (int i = 0; i < myArrayLength; i++) {
            int key = myArray[i];
            if (aux.containsKey(key)) {
                aux.put(key, (aux.get(key) + 1));
            } else {
                aux.put(key, 1);
            }
            aux.putIfAbsent(missingValue, 0);
        }

        //int max = Arrays.stream(myArray).max().getAsInt();


        /*
        for(Map.Entry<Integer,Integer> e : aux.entrySet()){
             System.out.println(e.getKey() + ": " + convertToStars(e.getValue()));
         }
*/
        aux.entrySet().stream().forEach((k) ->System.out.println(k.getKey() + ":" + convertToStars(k.getValue())));
        aux.entrySet().stream().filter(x -> x.getValue() == 1).map(x -> x.getValue()).reduce(0,Integer::sum);

       Integer max = aux.entrySet().stream().max(Comparator.comparing(Map.Entry::getValue)).get().getValue();

        aux.entrySet().size();
        /*
        aux.entrySet()
                .stream()
                .map(Map.Entry::getValue)
                .map(String::valueOf)
                .map(v -> v.replace(v, "*"))
                .forEach(System.out::println);

         */
    }
}
