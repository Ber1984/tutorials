package com.erick.company.staticword;

public class StaticWord {

    class Test {
        private static final int NUMBER = 1;

        public int getNUMBER() {
            return NUMBER;
        }
    }

    public static void main(String[] args) {
        StaticWord d =  new StaticWord();
        Test myTest = d.new Test();
        System.out.println(myTest.getNUMBER());
    }
}
