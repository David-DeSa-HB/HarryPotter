package fr.human.booster.HarryPotter.controllerRest;

import fr.human.booster.HarryPotter.entity.Subject;
import fr.human.booster.HarryPotter.entity.Teacher;
import fr.human.booster.HarryPotter.service.TeacherService;
import fr.human.booster.HarryPotter.dto.TeacherDTO;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teacher")
@AllArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping()
    public List<Teacher> List() {
        return teacherService.list();
    }

    @GetMapping("/{search}")
    public Teacher findTeacherBySearch(@PathVariable String  search){
        return teacherService.findBySearch(search);
    }

    @PostMapping
    public Teacher teacherService(@Valid @RequestBody TeacherDTO dto) {
        return teacherService.create(dto);
    }

    @PutMapping("/{id}")
    public void updateTeacherById(
            @PathVariable Integer id,
            @Valid @RequestBody TeacherDTO dto) {
        if (id != null) {
            teacherService.update(dto, id);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteTeacherByID(@PathVariable Integer id) {
        if (id != null) {
            teacherService.delete(teacherService.findOneById(id));
        }
    }


}