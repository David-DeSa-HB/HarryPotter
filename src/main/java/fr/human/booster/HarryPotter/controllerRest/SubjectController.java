package fr.human.booster.HarryPotter.controllerRest;

import fr.human.booster.HarryPotter.dto.SubjectDTO;
import fr.human.booster.HarryPotter.entity.Subject;
import fr.human.booster.HarryPotter.service.SubjectService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subject")
@AllArgsConstructor
public class SubjectController {

    private final SubjectService subjectService;

    @GetMapping
    public List<Subject> SubjectList(){
        return subjectService.list();
    }

//    @GetMapping("/{id}")
//    public Subject findSubjectById(@PathVariable Integer id){
//        return subjectService.findOneById(id);
//    }

    @GetMapping("/{search}")
    public Subject findSubjectBySearch(@PathVariable String  search){
           return subjectService.findBySearch(search);
    }

    @PostMapping
    public Subject createSubject(@Valid @RequestBody SubjectDTO subjectDTO){
        return subjectService.create(subjectDTO);
    }

    @PutMapping("/{id}")
    public void updateSubjectById(
            @PathVariable Integer id,
            @RequestBody SubjectDTO subjectDTO){
        if (id != null){
            subjectService.update(subjectDTO, id);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteSubjectById(@PathVariable Integer id){
        if (id != null){
            subjectService.delete(subjectService.findOneById(id));
        }
    }
}
