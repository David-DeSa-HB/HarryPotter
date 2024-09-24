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
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonView(JsonViews.ViewsStudents.class)
    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "teacher")
    private List<TypeOfClass> typeOfClasses = new ArrayList<>();

}