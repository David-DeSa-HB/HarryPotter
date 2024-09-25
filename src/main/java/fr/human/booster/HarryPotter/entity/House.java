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
public class House implements SluggerInterface {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(JsonViews.ViewsHouse.class)
    private Integer id;

    @Column(nullable = false)
    @JsonView({JsonViews.ViewsHouse.class, JsonViews.ViewsStudents.class})
    private String houseName;

    @Column(nullable = false)
    @JsonView(JsonViews.ViewsHouse.class)
    private String founderFirstName;

    @Column(nullable = false)
    @JsonView(JsonViews.ViewsHouse.class)
    private String founderLastName;

    @Column(nullable = false)
    @JsonView(JsonViews.ViewsHouse.class)
    private String slug;

    @OneToMany(mappedBy = "house")
    @Column(nullable = false)
    @JsonView(JsonViews.ViewsHouse.class)
    private List<HousePoint> housePoints = new ArrayList<>();

    @Override
    public String getField() {
        return houseName;
    }
}