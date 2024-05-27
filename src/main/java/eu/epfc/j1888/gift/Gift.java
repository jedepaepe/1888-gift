package eu.epfc.j1888.gift;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@NoArgsConstructor @AllArgsConstructor @Getter @Setter @ToString
@Entity
public class Gift {
    @Id @GeneratedValue
    private Long id;
    private String name;
    private double price;
    private String opportunity;
}
