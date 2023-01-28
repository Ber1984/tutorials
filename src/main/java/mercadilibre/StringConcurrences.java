package mercadilibre;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class StringConcurrences {

    static String RepetedLetterMax(String s) {
        HashMap<String, Integer> stringConcurrences = new HashMap<>();
        String fullChain = s.replace(" ", "").replace(",", "").toLowerCase();
        char[] c = fullChain.toCharArray();
        int lengthFullchain = c.length;
        Arrays.sort(c);

        for (int i = 0; i < lengthFullchain - 1; i++) {
            char n = c[i];
            String k = String.valueOf(n);
            if (stringConcurrences.containsKey(k)) {
                stringConcurrences.put(k, stringConcurrences.get(k) + 1);
            } else {
                stringConcurrences.put(k, 1);
            }
        }
        return stringConcurrences.entrySet()
                .stream()
                .parallel()
                .max(Comparator.comparing(Map.Entry::getValue))
                .map(x -> "La letra que mas se repite es la " + x.getKey().toUpperCase() + " con " + x.getValue() + " repeticiones")
                .get();
    }


    public static void main(String[] args) {
        System.out.println(RepetedLetterMax("Hola, mi nombre es Ariel, soy una sirena, vivo bajo el mar"));
    }
}
