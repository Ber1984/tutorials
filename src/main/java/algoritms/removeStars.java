package algoritms;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class removeStars {

    public static void main(String[] args) {
        System.out.println(removeStars("leet**cod*e"));
        //lecoe
        //dequeExample();
    }

    public static String removeStars(String s) {
        Deque<Character> dq = new ArrayDeque<>();
        for (int i = 0 ; i < s.length(); i++) {
            if(!dq.isEmpty()) {
                if(s.charAt(i) == '*') {
                    //dq.pop();
                    dq.remove(dq.peek());

                } else {
                    dq.push(s.charAt(i));
                }
            } else {
                dq.push(s.charAt(i));
            }
        }

        StringBuilder str = new StringBuilder();
        while (!dq.isEmpty()){
            str.append(dq.pop());
        }
        return str.reverse().toString();
    }

    public static void  dequeExample() {
        // Initializing an deque
        Deque<String> dq
                = new ArrayDeque<String>();

        // add() method to insert
        dq.add("For");
        dq.addFirst("Geeks");
        dq.addLast("Geeks");
        dq.addLast("removed");

        System.out.println(dq);
        System.out.println(dq.pop());
        System.out.println(dq.poll());
        System.out.println(dq.pollFirst());
        System.out.println(dq.pollLast());

        List<String> names = List.of("For test","Geeks", "Geeks", "removed");

        for (int i = 0 ; i <= names.size(); i++) {
            if(!dq.isEmpty()) {
                if(dq.peek().equals("removed")) {
                    dq.pollFirst();
                    dq.pollFirst();
                } else {
                    dq.push(names.get(i));
                }
            } else {
                dq.push(names.get(i));
            }
        }

        StringBuilder str = new StringBuilder();
        while (!dq.isEmpty()){
            str.append(dq.pop());
        }
        System.out.println("str" + str);
    }
}
