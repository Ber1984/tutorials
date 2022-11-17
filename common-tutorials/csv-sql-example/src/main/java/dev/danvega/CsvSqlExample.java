package dev.danvega;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@SpringBootApplication
@RestController
public class CsvSqlExample {
    public static void main(String[] args) {
        SpringApplication.run(CsvSqlExample.class);
    }

    @PersistenceContext
    private EntityManager entityManager;

    @PostMapping
    @Transactional
    public void save() throws IOException, CsvException {

        /*
        String query = "INSERT INTO userinfo ( login, upassword, email, mobile, fax, dob)"
             + " VALUES ( :a, :b, :c, :d, :e, :f)"

            em.createNativeQuery(query)
        .setParameter("a", objUser.getLogin())
        .setParameter("b", objUser.getUpassword())
        .setParameter("c", objUser.getEmail())
        .setParameter("d", objUser.getMobile())
        .setParameter("e", objUser.getFax())
        .setParameter("f", objUser.getDob())
        .executeUpdate()
         */
        //String fileName = "C:\\Users\\Erick_Romero\\Desktop\\tutorials\\tutorials\\common-tutorials\\csv-sql-example\\src\\main\\resources\\users.csv";
        URL resource = CsvSqlExample.class.getClassLoader().getResource("users.csv");

        if(Objects.isNull(resource)) throw new FileNotFoundException("File not found");
        CSVParser csvParser = new CSVParserBuilder().withSeparator(',').build(); // custom separator

        try (CSVReader reader = new CSVReaderBuilder(
                new FileReader(resource.getFile()))
                .withCSVParser(csvParser)   // custom CSV parser
                .withSkipLines(1)           // skip the first line, header info
                .build()) {
            List<String[]> elems = reader.readAll();


            //Optimal approach
            var users = new ArrayList<>();
            //elems.stream().forEach(x -> Arrays.stream(x).forEach(users::add));
            //System.out.print(users.size());
            //System.out.println("array" +  str);
            //List<String> users = Arrays.stream(str).map(x -> x.toLowerCase()).collect(Collectors.toList());
            //System.out.println("users" +  users);
            entityManager.createNativeQuery("INSERT INTO users (name,email) VALUES(:a)")
                    .setParameter("a", Arrays.asList("hola,como estas","que tal", "hola,como estas"))
                    .executeUpdate();



            /* Inneficient aproach
            elems.forEach(ele -> {
                System.out.println(Arrays.toString(ele));
                entityManager.createNativeQuery("INSERT INTO users (name) VALUES(:a)")
                        .setParameter("a", Arrays.toString(ele))
                        .executeUpdate();
            });

             */
            //elems.forEach(System.out::println);
        }
    }


    private List<String> createFakeData(){
        return List.of("Erick", "Jhorman", "Maria de los Angeles", "Jojoa");
    }
}