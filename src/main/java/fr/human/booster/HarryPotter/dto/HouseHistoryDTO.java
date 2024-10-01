package fr.human.booster.HarryPotter.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HouseHistoryDTO {

    private String oldHouseName;

    private String oldFounderFirstName;

    private String oldFounderLastName;
}
