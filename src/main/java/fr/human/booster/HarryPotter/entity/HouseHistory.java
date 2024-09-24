package fr.human.booster.HarryPotter.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class HouseHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "old_house_name")
    private String oldHouseName;

    @Column(name = "old_founder_first_name")
    private String oldFounderFirstName;

    @Column(name = "old_founder_last_name")
    private String oldFounderLastName;

}