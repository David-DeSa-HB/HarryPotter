package fr.human.booster.HarryPotter.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SubjectDTO {

    @NotNull (message = "cannot be null")
    @NotBlank (message = "required field")
    String name;
}
