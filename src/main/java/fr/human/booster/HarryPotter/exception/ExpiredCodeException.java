package fr.human.booster.HarryPotter.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ExpiredCodeException extends RuntimeException {

    public ExpiredCodeException(String message) {
        super(message);
    }

}
