package fr.human.booster.HarryPotter.controllerRest;

import com.fasterxml.jackson.annotation.JsonView;
import fr.human.booster.HarryPotter.DTO.StudentDTO;
import fr.human.booster.HarryPotter.entity.Student;
import fr.human.booster.HarryPotter.service.StudentService;
import fr.human.booster.HarryPotter.utils.JsonViews;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
@AllArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    @JsonView(JsonViews.ViewsStudents.class)
    public List<Student> StudentList() {
        return studentService.list();
    }

    @GetMapping("/{id}")
    @JsonView(JsonViews.ViewsStudents.class)
    public Student findStudentById(@PathVariable int id){
        return studentService.findOneById(id);
    }

    @PostMapping
    @JsonView(JsonViews.ViewsStudents.class)
    public Student createStudent(@Valid @RequestBody StudentDTO studentDTO){
        return studentService.create(studentDTO);
    }

    @PutMapping("/{id}")
    @JsonView(JsonViews.ViewsStudents.class)
    public void updateStudentById(
            @PathVariable Integer id,
            @Valid @RequestBody StudentDTO studentDTO) {
        if (id != null){
            studentService.update(studentDTO, id);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteStudentById(@PathVariable Integer id){
        if (id != null){
            studentService.delete(studentService.findOneById(id));
        }
    }
}
