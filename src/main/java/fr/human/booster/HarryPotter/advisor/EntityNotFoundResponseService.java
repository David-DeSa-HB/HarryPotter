package fr.human.booster.HarryPotter.advisor;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class EntityNotFoundResponseService {

    @ResponseBody
    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleEntityNotFoundHander(EntityNotFoundException exception) {
//        CustomResponse response = new CustomResponse();
//        response.setStatus(HttpStatus.BAD_GATEWAY.value());
//        response.setField(exception.getField());
//        response.setValue(exception.getValue());
//        response.setEntity(exception.getEntity());
//        return reponse;
        return "Not Found";
    }

}