package com.erick.company.collections;

import java.util.HashMap;
import java.util.Map;


public class MapTest {
    public static void main(String[] args) {
      /*
       HashMap<K, V> is a part of Java’s collection since Java 1.2. This class is found in java.util package.
       It provides the basic implementation of the Map interface of Java.
       It stores the data in (Key, Value) pairs, and you can access them by an index of another type (e.g. an Integer).
       One object is used as a key (index) to another object (value).
       If you try to insert the duplicate key, it will replace the element of the corresponding key.
       HashMap is similar to HashTable, but it is unsynchronized. It allows to store the null keys as well,
       but there should be only one null key object and there can be any number of null values.
       This class makes no guarantees as to the order of the map. To use this class and its meth    ods,
       you need to import java.util.HashMap package or its superclass.
      */
        /*
         To access a value one must know its key. HashMap is known as HashMap because it uses a technique called Hashing.
         Hashing is a technique of converting a large String to small String that represents the same String.
         A shorter value helps in indexing and faster searches.
         HashSet also uses HashMap internally.
         */


        Map<String, Character> map = new HashMap();

    }
}
