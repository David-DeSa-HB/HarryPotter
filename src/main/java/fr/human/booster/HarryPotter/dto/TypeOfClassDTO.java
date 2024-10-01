package fr.human.booster.HarryPotter.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TypeOfClassDTO {

    @NotBlank (message = "required field")
    private Integer year;

    @NotBlank (message = "required field")
    private Integer teacherId;

    @NotBlank (message = "required field")
    private Integer subjectId;
}
