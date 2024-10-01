package fr.human.booster.HarryPotter.controllerRest;

import fr.human.booster.HarryPotter.entity.TypeOfClass;
import fr.human.booster.HarryPotter.service.TypeOfClassService;
import fr.human.booster.HarryPotter.dto.TypeOfClassDTO;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/typeOfClass")
@AllArgsConstructor
public class TypeOfClassController {

    private final TypeOfClassService typeOfClassService;

    @GetMapping()
    public List<TypeOfClass> List() {
        return typeOfClassService.list();
    }

    @GetMapping("/{id}")
    public TypeOfClass findTypeOfClassById(@PathVariable Integer id) {
        return typeOfClassService.findOneById(id);
    }

    @PostMapping
    public TypeOfClass typeOfClassService(@Valid @RequestBody TypeOfClassDTO dto) {
        return typeOfClassService.create(dto);
    }

    @PutMapping("/{id}")
    public void updateTypeOfClassById(
            @PathVariable Integer id,
            @Valid @RequestBody TypeOfClassDTO dto) {
        if (id != null) {
            typeOfClassService.update(dto, id);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteTypeOfClassByID(@PathVariable Integer id) {
        if (id != null) {
            typeOfClassService.delete(typeOfClassService.findOneById(id));
        }
    }
}