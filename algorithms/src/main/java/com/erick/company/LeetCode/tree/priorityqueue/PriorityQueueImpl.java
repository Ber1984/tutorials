package com.erick.company.LeetCode.tree.priorityqueue;


import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.concurrent.ArrayBlockingQueue;

/*

 */
public class PriorityQueueImpl {


    public static void main(String[] args) {
    PriorityQueue<Integer> minHeap = new PriorityQueue();

    minHeap.add(2);

    minHeap.peek(); //retrieve and not remove
    minHeap.remove(); //retrieve and remove and throws an exception if minHeap is empty
    minHeap.poll(); //retrieve and remove


    minHeap.offer(3); //add values

        /*
        In Java's Queue interface (which PriorityQueue implements), both add() and offer() are used to insert elements — but there's a subtle difference between them:

         add(E e)
        Throws an exception (IllegalStateException) if the element cannot be added.

        Typically used when failure is unexpected or should be handled by exception.

        In PriorityQueue, it usually works the same as offer() because there's no capacity limit.

        queue.add(10); // Adds or throws exception

        offer(E e)
        Returns true or false depending on whether the element was successfully added.

        Safer for bounded queues (like ArrayBlockingQueue) where insertion can fail silently if the queue is full.
        Preferred when you want to avoid exceptions.

        queue.offer(10); // Adds or returns false

        Method | Throws Exception on Failure | Returns Status | Safer for Bounded Queues
        add() |        ✅ Yes                           | ❌ No              | ❌ No
        offer()         | ❌ No                          | ✅ Yes             | ✅ Yes
         */


        //Example with ArrayBlockingQueue
        // Bounded queue with capacity 2
        ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(2);

        // Add two elements - both will succeed
        queue.add(1);
        queue.add(2);

        // Offer a third element - returns false (no exception)
        boolean offerResult = queue.offer(3);
        System.out.println("Offer result: " + offerResult); // false

        // Try to add a third element - throws IllegalStateException
        //queue.add(3); // 💥 Exception: Queue full


        //create a max_heap

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        maxHeap.offer(50);
        maxHeap.offer(20);
        maxHeap.offer(500);

        System.out.println(maxHeap);


        //Order Priority queue by age

        PriorityQueue<Person> people = new PriorityQueue<>(new SortByAge());
        people.offer(new Person("Erick", 12));
        people.offer(new Person("Maria", 30));
        people.offer(new Person("Graciela", 50));

        System.out.println(people);

    }
}

class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class SortByAge implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        return o1.getAge() - o2.getAge();
    }
}
