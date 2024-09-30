package fr.human.booster.HarryPotter.exception;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class CustomEntityNotFoundException extends EntityNotFoundException {

    private String message = "Ce ne sont pas les droïdes que vous recherchez.";

}
