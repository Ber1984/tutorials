package org.demo;

import org.demo.entity.PaperCategory;
import org.demo.entity.PaperGrammage;
import org.demo.entity.PaperType;
import org.demo.repository.PaperCategoryRepository;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.transaction.Transactional;
import java.util.Arrays;

import org.slf4j.Logger;
@SpringBootApplication
public class JpaManyRelationships {
    private static final Logger log = LoggerFactory.getLogger(JpaManyRelationships.class);

    public static void main(String[] args) {
        SpringApplication.run(JpaManyRelationships.class);
    }

    @Bean
    @Transactional
    CommandLineRunner commandLineRunner(PaperCategoryRepository paperCategoryRepository) {
      return args  -> {
          PaperGrammage paperGrammage = new PaperGrammage();
          paperGrammage.setGrammage("Grammage");
          paperGrammage.setPaperTypes(Arrays.asList( new PaperType("Test"),  new PaperType("Test1")));

          PaperGrammage paperGrammage1 = new PaperGrammage();
          paperGrammage1.setGrammage("Grammage1");
          paperGrammage1.setPaperTypes(Arrays.asList( new PaperType("Test1"),  new PaperType("Test2")));

          PaperCategory paperCategory = new PaperCategory();
          paperCategory.setPaperGrammages(Arrays.asList(paperGrammage, paperGrammage1));

          paperCategoryRepository.save(paperCategory);

          //fetch all PaperCategories
          for (PaperCategory paperCategory1 : paperCategoryRepository.findAll()) {
              log.info(paperCategory1.toString());
          }
        };
    }
}

