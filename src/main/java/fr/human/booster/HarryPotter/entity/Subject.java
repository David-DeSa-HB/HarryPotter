package fr.human.booster.HarryPotter.entity;

import fr.human.booster.HarryPotter.slugger.SluggerInterface;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Subject implements SluggerInterface {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String subjectName;

    @Column(nullable = false)
    private String slug;

    @Override
    public String getField() {
        return subjectName;
    }
}