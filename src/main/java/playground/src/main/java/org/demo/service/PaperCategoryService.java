package playground.src.main.java.org.demo.service;

import org.demo.entity.PaperCategory;
import playground.src.main.java.org.demo.repository.PaperCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaperCategoryService {

    private final PaperCategoryRepository paperCategoryRepository;

    public PaperCategoryService(PaperCategoryRepository paperCategoryRepository) {
        this.paperCategoryRepository = paperCategoryRepository;
    }

    public List<PaperCategory> getPaperCategory() {
       return paperCategoryRepository.findAll();
    }
}
