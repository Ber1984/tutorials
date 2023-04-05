package com.erick.company.javaquestionslinkdin;

public class JavaQuestions  implements VariableDataMember {

    public static void main(String[] args) {
        byteArrayString();
        int val=100;
        System.out.println(val);
    }

    private static void posincrement() {
        int x = 5;
        System.out.println(x++ + ++x - x-- - --x);
    }

    private static void byteArrayString() {
        byte[] b={100,101,102};;
        String s=new String(b);
        System.out.println(s);
    }
}

interface VariableDataMember {
    int val=10;
}
