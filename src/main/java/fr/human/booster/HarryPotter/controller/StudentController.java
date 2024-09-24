package fr.human.booster.HarryPotter.controller;

import com.fasterxml.jackson.annotation.JsonView;
import fr.human.booster.HarryPotter.DTO.StudentCreateDTO;
import fr.human.booster.HarryPotter.entity.Student;
import fr.human.booster.HarryPotter.service.StudentService;
import fr.human.booster.HarryPotter.utils.JsonViews;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
@AllArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/")
    @JsonView(JsonViews.ViewsStudents.class)
    public List<Student> List() {
        return studentService.list();
    }

    @GetMapping("/{id}")
    @JsonView(JsonViews.ViewsStudents.class)
    public Student findOneById(@PathVariable int id){
        return studentService.getOneById(id);
    }

    @PostMapping("/")
    public Student createStudent(@RequestBody StudentCreateDTO studentCreateDTO){
        return studentService.create(studentCreateDTO);
    }

    @PostMapping("/{id}")
    public void updateStudentById(@RequestBody StudentCreateDTO studentCreateDTO, @PathVariable int id){
        studentService.update(studentCreateDTO, id);
    }

    @DeleteMapping("/{id}")
    public void deleteBorneById(@PathVariable int id){
        studentService.delete(studentService.getOneById(id));
    }
}
