package fr.human.booster.HarryPotter.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class AlreadyActiveException extends RuntimeException {

    public AlreadyActiveException(String message) {
        super(message);
    }
}
