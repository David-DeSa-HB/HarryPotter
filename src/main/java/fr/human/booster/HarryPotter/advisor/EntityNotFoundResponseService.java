package fr.human.booster.HarryPotter.advisor;

import fr.human.booster.HarryPotter.exception.CustomEntityNotFoundException;
import fr.human.booster.HarryPotter.response.CustomResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class EntityNotFoundResponseService {

    @ResponseBody
<<<<<<< HEAD
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
=======
    @ExceptionHandler(CustomEntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public CustomResponse entityNotFoundHandler(CustomEntityNotFoundException exception) {
        CustomResponse response = new CustomResponse();
        response.setStatus(HttpStatus.NOT_FOUND.value());
        response.setMessage(exception.getMessage());
        return response;
>>>>>>> f37dcc8708f34b8f1dba1f162d9bebc224ffaaff
    }

}