package fr.human.booster.HarryPotter.dto;

import fr.human.booster.HarryPotter.validation.constrain.LegitPassword;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UniqueElements;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserCreateDTO {

    @NotBlank(message = "required field")
    @Email(message = "invalid email")
    private String email;

    @NotBlank(message = "required field")
    private String nickname;

    @LegitPassword(message = "invalid password")
    private String password;

    @NotBlank(message = "required field")
    private String confirmedPassword;
}
