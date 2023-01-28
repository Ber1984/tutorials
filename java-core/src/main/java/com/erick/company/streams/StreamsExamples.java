package com.erick.company.streams;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsExamples {

    public static void main(String[] args) {
        List<Person> people = getPeople();

        // Imperative approach
        /*List<Person> females = new ArrayList<>();
        for(Person person:people){
            if(person.getGender().equals(Gender.FEMALE)){
                females.add(person);
            }
        }
        females.forEach(System.out::println);
        */
        //Filter
        List<Person> females = people.stream()
                .filter(person -> person.getGender().equals(Gender.FEMALE))
                .collect(Collectors.toList());

        //females.forEach(System.out::println);

        // sort
        /*
        List<Person> sorted =  people.stream()
                 .sorted(Comparator.comparing(Person::getAge))
                 .collect(Collectors.toList());

        sorted.forEach(System.out::println);

        List<Person> sorted2 =  people.stream()
                .sorted(Comparator.comparing(Person::getAge).reversed())
                .collect(Collectors.toList());
        sorted2.forEach(System.out::println);
        */
        // All match
        boolean allMatch = people.stream()
                .allMatch(person -> person.getAge() > 5);

        System.out.println(allMatch);

        // anyMatch
        boolean anyMatch = people.stream()
                .anyMatch(person -> person.getAge() > 121);
        System.out.println(anyMatch);

        // noneMatch
        boolean noneMatch = people.stream()
                .noneMatch(person -> person.getName().equals("Antonio"));
        System.out.println(noneMatch);

        // Max
        people.stream()
                .max(Comparator.comparing(Person::getAge))
                .ifPresent(System.out::println);
        // Min
        people.stream()
                .min(Comparator.comparing(Person::getAge))
                .ifPresent(System.out::println);

        //Group
        Map<Gender, List<Person>> groupByGender = people.stream()
                .collect(Collectors.groupingBy(Person::getGender));

        groupByGender.forEach(((gender, people1) -> {
            System.out.println(gender);
            people1.forEach(x -> System.out.println(x));
            System.out.println();
        }));
/*
        List<Person> filterd =  people.stream()
                .filter(person -> person.getGender().equals(Gender.FEMALE))
                .collect(Collectors.toList());
        filterd.forEach(System.out::println);
*/
        Optional<String> oldestFemaleAge = Optional.of(people.stream()
                .filter(person -> person.getGender().equals(Gender.FEMALE))
                .max(Comparator.comparing(Person::getAge))
                .map(Person::getName).orElse("Desconocido"));
        oldestFemaleAge.ifPresent(System.out::println);

        // Accumulate names into a List
        List<String> list = people.stream()
                .map(Person::getName)
                .collect(Collectors.toList());

        // Accumulate names into a TreeSet
        Set<String> set = people.stream()
                .map(Person::getName)
                .collect(Collectors.toCollection(TreeSet::new));

        // Convert elements to strings and concatenate them, separated by commas
        /*String joined = things.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", "));
*/
        // Compute sum of salaries of employee
        /*int total = employees.stream()
                .collect(Collectors.summingInt(Employee::getSalary));
         */

/*
        // Convert elements to strings and concatenate them, separated by commas
        String joined = things.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", "));

        // Compute sum of salaries of employee
        int total = employees.stream()
                .collect(Collectors.summingInt(Employee::getSalary));

        // Group employees by department
        Map<Department, List<Employee>> byDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));

        // Compute sum of salaries by department
        Map<Department, Integer> totalByDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.summingInt(Employee::getSalary)));

        // Partition students into passing and failing
        Map<Boolean, List<Student>> passingFailing = students.stream()
                .collect(Collectors.partitioningBy(s -> s.getGrade() >= PASS_THRESHOLD));
         */

        int[] array = {5, 2, 3, 4};
        String chart = "DDDDC";

        char[] c = chart.toCharArray();
        chart.length();
        System.out.println(c);
        String car = chart.concat("ddd");
        System.out.println(car);
        List<String> fin = new ArrayList();

        //get the letter according to a number
        String letters = "3a2bc4dddd";

        HashMap<Character, Integer> map = new HashMap<>();
        map.put('a', 3);
        map.put('b', 2);
        map.put('c', 1);
        map.put('d', 4);

        String myList = map.entrySet().stream().map(Map.Entry::getValue).map(Objects::toString).collect(Collectors.joining());
        System.out.println(myList);


        String[] words = new String[]{"xbc", "pcxbcf", "xb", "cxbc", "pcxbc"};
        List<String> listWord = List.of(words);
        List<String> orderList = listWord.stream().sorted(Comparator.comparing(String::length)).collect(Collectors.toList());
        String sorted = "bdca".chars()
                .sorted()
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();


        System.out.println(orderList);

        String test = "bdca";
        if (test.contains("bda")) {
            System.out.println("here");
        }

        List<Integer> terminalOperation = List.of(2, 6, 5, 5, 1);
        Set<Integer> integerSet = terminalOperation.stream().collect(Collectors.toSet());
        integerSet = new LinkedHashSet<>(integerSet);
        integerSet.forEach(System.out::println);

        System.out.println(getEvenNumbers(10, 10));


    }

    public static void getNumbers() {

    }

    private static List<Integer> getEvenNumbers(int offset, int limit) {
        int greeting;
        return Stream.iterate(0, i -> i + 1)
                .filter(i -> i % 2 == 0)
                .skip(offset)
                .limit(limit)
                .collect(Collectors.toList());
    }

    private static List<Person> getPeople() {
        return List.of(
                new Person("James Bond", 20, Gender.MALE),
                new Person("Alina Smith", 33, Gender.FEMALE),
                new Person("Helen White", 57, Gender.FEMALE),
                new Person("Alex Boz", 14, Gender.MALE),
                new Person("Jamie Goa", 99, Gender.MALE),
                new Person("Anna Cook", 7, Gender.FEMALE),
                new Person("Zelda Brown", 120, Gender.FEMALE));
    }
}
