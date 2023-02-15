package hibernate.Sunday_teamwork.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import sunday_relations.example1.entity.Company;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "person_id")
    @ToString.Exclude
    private Person person;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "serviceProvider_id", unique = true)
    private ServiceProvider serviceProvider;

}


