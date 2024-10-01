package fr.human.booster.HarryPotter.validation.validator;

import fr.human.booster.HarryPotter.validation.constrain.LegitPassword;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class LegitPasswordValidator implements ConstraintValidator<LegitPassword, String> {

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        if (!password.contains("*")) {
//            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Le mot de passe doit contenir un *");
            return false;
        }
        if (password.length() < 5) {
//            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Le mot de passe doit faire au moins 5 caractères");
            return false;
        }
        return true;
    }

}
