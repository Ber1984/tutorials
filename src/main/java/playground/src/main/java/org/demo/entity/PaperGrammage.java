package playground.src.main.java.org.demo.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "PAPER_GRAMMAGE")
public class PaperGrammage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pg_id")
    private Long id;

    private String grammage;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<PaperType> paperTypes;
    public PaperGrammage() {
    }
    public List<PaperType> getPaperTypes() {
        return paperTypes;
    }

    public void setPaperTypes(List<PaperType> paperTypes) {
        this.paperTypes = paperTypes;
    }

    public String getGrammage() {
        return grammage;
    }

    public void setGrammage(String grammage) {
        this.grammage = grammage;
    }

    @Override
    public String toString() {
        return "PaperGrammage{" +
                "id=" + id +
                ", grammage='" + grammage + '\'' +
                ", paperTypes=" + paperTypes +
                '}';
    }
}
