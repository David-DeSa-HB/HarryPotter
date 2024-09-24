package fr.human.booster.HarryPotter.entity;

import com.fasterxml.jackson.annotation.JsonView;
import fr.human.booster.HarryPotter.slugger.SluggerInterface;
import fr.human.booster.HarryPotter.utils.JsonViews;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import org.hibernate.mapping.Join;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Student implements SluggerInterface {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonView(JsonViews.ViewsStudents.class)
    @Column(nullable = false)
    private Integer yearOfBirth;

    @JsonView(JsonViews.ViewsStudents.class)
    @Column(nullable = false)
    private String name;

    @JsonView(JsonViews.ViewsStudents.class)
    @Column(nullable = false)
    private boolean isAlive;

    @ManyToOne
    @JsonView(JsonViews.ViewsStudents.class)
    private House house;

    private String slug;

    @ManyToMany
    @JoinTable(
            name ="student_type_of_class",
            inverseJoinColumns = {@JoinColumn (name =  "type_of_class_id")}
    )
    private List<TypeOfClass> typeOfClasses = new ArrayList<>();

    @Override
    public String getField() {
        return name;
    }
}