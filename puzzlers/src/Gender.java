import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Gender {

    public static void main(String[] args) {
        var person = new ArrayList<String>();
        var result = new HashMap<String, String>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many people do you wanna add? ");
        int numberOfPeople = scanner.nextInt();

        int i = 0;
        while(i < numberOfPeople) {
           System.out.println("Write the name and gender like this \n name - gender");
           String name = scanner.next();
           person.add(name);
           i++;
        }

        for(String name : person) {
            String value = name.split("-")[0];
            String gender = name.split("-")[1];

            if(name.contains("masculine")) {
                result.put(gender, value);
            } else {
                result.put(gender, value);
            }
        }

        result.forEach((k,v) -> System.out.println("Gender: " + k + " Name: " + v));
    }
}
