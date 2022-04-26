package my.stuff.colorcollector.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class ColorInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String name;
    String value1;
    String value2;

    public ColorInfo() {
    }

    public ColorInfo(String name, String value1, String value2) {
        this.name = name;
        this.value1 = value1;
        this.value2 = value2;
    }
}
