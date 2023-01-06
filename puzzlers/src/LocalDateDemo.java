import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateDemo {

    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
        String formatDate = LocalDate.now().format(formatter);
        System.out.println(formatDate);
        System.out.println("formatDate = " + Integer.valueOf(formatDate));

    }
}
