package playground.src.main.java.org.demo.entity;

import javax.persistence.*;

@Table(name = "PAPER_TYPE")
@Entity
public class PaperType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pT_id")
    private Long id;
    private String type; //no need to add column annotation because the property defined in class is the same in the database
    public PaperType(String type) {
        this.type = type;
    }

    public PaperType() {

    }
    public Long getId() {
        return id;
    }
    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "PaperType{" +
                "id=" + id +
                ", type='" + type + '\'' +
                '}';
    }
}
