package com.erick.company.LeetCode.graph.dag;

import java.util.ArrayList;
import java.util.List;

class Person {
    String name;
    List<Person> parents = new ArrayList<>();
    List<Person> children = new ArrayList<>();

    Person(String name) {
        this.name = name;
    }

    void addParent(Person parent) {
        this.parents.add(parent);
        parent.children.add(this); // bi-directional link
    }

    public static void main(String[] args) {
        Person mother = new Person("Mother");
        Person father = new Person("Father");

        Person me = new Person("Me");
        me.addParent(mother);
        me.addParent(father);

        Person brother = new Person("Brother");
        brother.addParent(mother);
        brother.addParent(father);

    }
}
