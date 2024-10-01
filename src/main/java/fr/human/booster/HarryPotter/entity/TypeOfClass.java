package fr.human.booster.HarryPotter.entity;

import com.fasterxml.jackson.annotation.JsonView;
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
public class TypeOfClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(JsonViews.ViewsStudents.class)
    private Integer id;

    @JsonView(JsonViews.ViewsStudents.class)
    @Column(nullable = false)
    private Integer yearTaught;

    @ManyToMany(mappedBy = "typeOfClasses")
    @JsonView(JsonViews.ViewsStudents.class)
    private List<Student> students = new ArrayList<>();

    @ManyToOne
    @JoinColumn(nullable = false)
    @JsonView(JsonViews.ViewsStudents.class)
    private Teacher teacher;

    @ManyToOne
    @JoinColumn(nullable = false)
    @JsonView(JsonViews.ViewsStudents.class)
    private Subject subject;
}