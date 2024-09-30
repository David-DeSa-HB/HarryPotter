package fr.human.booster.HarryPotter.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomResponse {

    private int status;

    private String message = "Ce ne sont pas les droïdes que vous recherchez.";
}
