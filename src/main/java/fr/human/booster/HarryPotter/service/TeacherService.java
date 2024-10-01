package fr.human.booster.HarryPotter.service;

import fr.human.booster.HarryPotter.exception.CustomEntityNotFoundException;
import fr.human.booster.HarryPotter.repository.TeacherRepository;
import fr.human.booster.HarryPotter.dto.TeacherDTO;
import fr.human.booster.HarryPotter.entity.Teacher;
import fr.human.booster.HarryPotter.service.interfaces.ServiceCUDInterface;
import fr.human.booster.HarryPotter.service.interfaces.ServiceListInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TeacherService implements ServiceListInterface<Teacher, Integer>, ServiceCUDInterface <Teacher, TeacherDTO, TeacherDTO, Integer> {

    private final TeacherRepository teacherRepository;

    @Override
    public Teacher findOneById(Integer id) {
        return teacherRepository
                .findById(id)
                .orElseThrow(CustomEntityNotFoundException::new);
    }

    @Override
    public List<Teacher> list() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher update(TeacherDTO dto, Integer id) {
        Teacher teacher = TeacherFromDTO(this.findOneById(id), dto);
        return teacherRepository.saveAndFlush(teacher);
    }

    @Override
    public Teacher create(TeacherDTO dto) {
        Teacher teacher = TeacherFromDTO(new Teacher(), dto);
        return teacherRepository.saveAndFlush(teacher);
    }

    @Override
    public void delete(Teacher teacher) {
        teacherRepository.delete(teacher);
    }

    public Teacher findBySearch(String search) {
        Optional<Teacher> optional;
        try {
            optional = teacherRepository.findById(Integer.parseInt(search));
        } catch (NumberFormatException e) {
            optional = teacherRepository.findByNameContainingIgnoreCase(search);
        }
        return optional.orElseThrow(CustomEntityNotFoundException::new);
    }

    public Teacher TeacherFromDTO(Teacher teacher, TeacherDTO dto) {
        teacher.setName(dto.getName());
        return teacher;
    }
}