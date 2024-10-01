package fr.human.booster.HarryPotter.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class HouseDTO {

    @NotBlank(message = "required field")
    private String houseName;

    @NotBlank (message = "required field")
    private String founderFirstName;

    @NotBlank (message = "required field")
    private String founderLastName;

}
