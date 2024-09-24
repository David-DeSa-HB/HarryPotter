package fr.human.booster.HarryPotter.DTO;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentCreateDTO {

    @NotNull (message = "cannot be null")
    @NotBlank (message = "required field")
    private String Name;

    @NotNull (message = "cannot be null")
    @NotBlank (message = "required field")
    private Integer yearOfBirth;

    @NotNull (message = "cannot be null")
    private boolean isAlive;

    @NotNull (message = "cannot be null")
    @NotBlank (message = "required field")
    @Min(value = 1, message = "1 Gryffondor, \n 3 Serpentard, \n 4 Poufsouffle, \n 5 Serdaigle, \n 3 Inconnu")
    @Max(value = 6, message = "1 Gryffondor, \n 3 Serpentard, \n 4 Poufsouffle, \n 5 Serdaigle, \n 3 Inconnu")
    private int houseId;
}
