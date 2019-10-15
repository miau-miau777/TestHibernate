package models;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
public abstract class Model implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    public Model() {
    }

    public Model(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
