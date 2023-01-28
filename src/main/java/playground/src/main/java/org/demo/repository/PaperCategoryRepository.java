package playground.src.main.java.org.demo.repository;

import org.demo.entity.PaperCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaperCategoryRepository extends JpaRepository<PaperCategory,Long> {

}
