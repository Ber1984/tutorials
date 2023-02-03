package LeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SortingTheSentence {

    public static void main(String[] args) {
            System.out.println(sortSentence("Myself2 Me1 I4 and3"));
        }

        public static String sortSentence(String s) {
            Map<Integer, String> map = new HashMap<>();
            int count = 1;
            String[] sArray = s.split(" ");
            StringBuilder stringBuilder = new StringBuilder();
            for(int i = 0;i<sArray.length;i++) {
            for(int j = 0;j<sArray.length;j++) {
                if(sArray[j].contains(String.valueOf(count))) {
                    map.put(i, sArray[j].replaceAll("\\d", ""));
                    stringBuilder.append(sArray[j].replaceAll("\\d", "")).append(" ");
                    count++;
                    break;
                }
            }

        }
        map.forEach((k,v) -> System.out.println("value" + v));
            System.out.println("stringBuilder" + stringBuilder);
        return map.values().stream().collect(Collectors.joining(" "));
    }


}


