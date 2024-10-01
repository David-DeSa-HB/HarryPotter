package fr.human.booster.HarryPotter.service;

import fr.human.booster.HarryPotter.exception.CustomEntityNotFoundException;
import fr.human.booster.HarryPotter.repository.TypeOfClassRepository;
import fr.human.booster.HarryPotter.dto.TypeOfClassDTO;
import fr.human.booster.HarryPotter.entity.TypeOfClass;
import fr.human.booster.HarryPotter.service.interfaces.ServiceCUDInterface;
import fr.human.booster.HarryPotter.service.interfaces.ServiceListInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TypeOfClassService implements ServiceListInterface<TypeOfClass, Integer>, ServiceCUDInterface<TypeOfClass, TypeOfClassDTO, TypeOfClassDTO, Integer> {

    private final TypeOfClassRepository typeOfClassRepository;
    private final TeacherService teacherService;
    private final SubjectService subjectService;

    @Override
    public TypeOfClass findOneById(Integer id) {
        return typeOfClassRepository
                .findById(id)
                .orElseThrow(CustomEntityNotFoundException::new);
    }

    @Override
    public List<TypeOfClass> list() {
        return typeOfClassRepository.findAll();
    }

    @Override
    public TypeOfClass create(TypeOfClassDTO dto) {
        TypeOfClass typeOfClass = TypeOfClassFromDTO(new TypeOfClass(), dto);
        return typeOfClassRepository.saveAndFlush(typeOfClass);
    }

    @Override
    public TypeOfClass update(TypeOfClassDTO dto, Integer id) {
        TypeOfClass typeOfClass = TypeOfClassFromDTO(this.findOneById(id), dto);
        return typeOfClassRepository.saveAndFlush(typeOfClass);
    }

    @Override
    public void delete(TypeOfClass typeOfClass) {
        typeOfClassRepository.delete(typeOfClass);
    }

    public TypeOfClass TypeOfClassFromDTO(TypeOfClass typeOfClass, TypeOfClassDTO dto) {
        typeOfClass.setYearTaught(dto.getYear());
        typeOfClass.setTeacher(teacherService.findOneById(dto.getTeacherId()));
        typeOfClass.setSubject(subjectService.findOneById(dto.getSubjectId()));
        return typeOfClass;
    }
}