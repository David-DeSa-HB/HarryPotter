package fr.human.booster.HarryPotter.entity;

import com.fasterxml.jackson.annotation.JsonView;
import fr.human.booster.HarryPotter.utils.JsonViews;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class HousePoint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    @JsonView(JsonViews.ViewsHouse.class)
    private Integer year;

    @Column(nullable = false)
    @JsonView(JsonViews.ViewsHouse.class)
    private Integer totalPoint;

    @ManyToOne
    @JoinColumn(nullable = false)
    private House house;


}