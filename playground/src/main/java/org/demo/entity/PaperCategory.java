package org.demo.entity;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "PAPER_CATEGORY")
public class PaperCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pc_id")
    private Long id;

    //your fields here

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<PaperGrammage> paperGrammages;

    public List<PaperGrammage> getPaperGrammages() {
        return paperGrammages;
    }

    public void setPaperGrammages(List<PaperGrammage> paperGrammages) {
        this.paperGrammages = paperGrammages;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "PaperCategory{" +
                "id=" + id +
                ", paperGrammages=" + paperGrammages +
                '}';
    }


}
