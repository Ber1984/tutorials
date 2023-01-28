package javastreamdebugger;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmployeeDatabase {
    public static List<Employee> getEmployees() {
        return Stream.of(new Employee(101, "Basant", "DEV", 500000),
                new Employee(101, "Santosh", "FS", 700000),
                new Employee(101, "Sam", "QA", 4000000),
                new Employee(101, "Jhon", "DEV", 400000),
                new Employee(101, "Ajay", "DEV", 900000),
                new Employee(101, "Sam", "QA", 40000),
                new Employee(101, "Basant", "DEV", 700000),
                new Employee(101, "Yugendra", "QA", 100000),
                new Employee(101, "Ram", "UI", 300000),
                new Employee(101, "Bikash", "ADMIN", 350000),
                new Employee(101, "Bala", "Mng", 200000)
        ).collect(Collectors.toList());
    }
}
