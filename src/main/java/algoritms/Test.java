package algoritms;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class Test {

    public static void main(String[] args) {
        //System.out.println(removeDuplicates("abbaca"));
        System.out.println(removeDuplicatesWithStack("abbaca"));
    }
    public static String removeDuplicates(String s) {
        int i = 0, j = 1;
        List<Character> fillLetters = fillLetters(s);
        List<Character> list = new ArrayList<>(fillLetters);
        int listSize = list.size();
        while(i < listSize) {
            if(j >= list.size()) break;
            char letter = list.get(i);
            char letter1 = list.get(j);
            if(letter == letter1) {
                fillLetters.remove(i);
                fillLetters.remove(--j);
                i = 0;
                j = 1;
                list = fillLetters;
            } else {
                i++;
                j++;
            }
        }
        return list.stream().map(x -> x.toString()).collect(Collectors.joining());
    }

    private static List<Character> fillLetters(String s){
        List<Character> strList = new ArrayList<>();
        for(Character str:s.toCharArray()) {
            strList.add(str);
        }
        return strList;
    }

    public static String removeDuplicatesWithStack(String s) {
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < s.length() ;i++){
            if(!st.isEmpty()){
                if(st.peek() == s.charAt(i)) {
                    st.pop(); //remove the character
                }else{
                    st.push(s.charAt(i)); //add character to the stack
                }
            }else{
                st.push(s.charAt(i)); //add the character
            }
        }
        StringBuilder ns = new StringBuilder("");
        while(!st.isEmpty()){
            ns.append(st.pop());
        }
        return ns.reverse().toString();
    }
}
