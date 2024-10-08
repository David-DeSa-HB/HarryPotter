package fr.human.booster.HarryPotter.entity;

import com.fasterxml.jackson.annotation.JsonView;
import fr.human.booster.HarryPotter.slugger.SluggerInterface;
import fr.human.booster.HarryPotter.utils.JsonViews;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Student implements SluggerInterface {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(JsonViews.ViewsStudents.class)
    private Integer id;

    @JsonView(JsonViews.ViewsStudents.class)
    @Column(nullable = false)
    private Integer yearOfBirth;

    @JsonView(JsonViews.ViewsStudents.class)
    @Column(nullable = false)
    private String name;

    @JsonView(JsonViews.ViewsStudents.class)
    @Column(nullable = false)
    private Boolean isAlive;

    @ManyToOne
    @JsonView(JsonViews.ViewsStudents.class)
    private House house;

    @JsonView(JsonViews.ViewsStudents.class)
    private String slug;

    @ManyToMany
    @JoinTable(
            name ="student_type_of_class",
            joinColumns = {@JoinColumn (name =  "student_id")},
            inverseJoinColumns = {@JoinColumn (name =  "type_of_class_id")}
    )
    private List<TypeOfClass> typeOfClasses = new ArrayList<>();

    @Override
    public String getField() {
        return name;
    }
}