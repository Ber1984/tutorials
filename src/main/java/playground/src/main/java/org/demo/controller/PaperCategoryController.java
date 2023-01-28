package playground.src.main.java.org.demo.controller;


import org.demo.entity.PaperCategory;
import org.demo.service.PaperCategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PaperCategoryController {

    private final PaperCategoryService paperCategoryService;
    private static Logger log = LoggerFactory.getLogger(PaperCategoryController.class);

    public PaperCategoryController(PaperCategoryService paperCategoryService) {
        this.paperCategoryService = paperCategoryService;
    }

    @GetMapping("")
    public String home(Model model) {
        var paperCategory = paperCategoryService.getPaperCategory();
        model.addAttribute("paperCategory", paperCategory);

        //fetch all PaperCategories
        for (PaperCategory paperCategory1 : paperCategory) {
            log.info(paperCategory1.toString());
        }
        return "index";
    }
}
