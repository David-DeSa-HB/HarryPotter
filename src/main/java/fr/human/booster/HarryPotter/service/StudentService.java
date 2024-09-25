package fr.human.booster.HarryPotter.service;

import fr.human.booster.HarryPotter.DTO.StudentDTO;
import fr.human.booster.HarryPotter.entity.Student;
import fr.human.booster.HarryPotter.repository.StudentRepository;
import fr.human.booster.HarryPotter.service.interfaces.ServiceInterface;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentService implements ServiceInterface<Student, Integer, StudentDTO> {

    private final StudentRepository studentRepository;
    private final HouseService houseService;

    @Override
    public Student create(StudentDTO studentDTO) {
        Student student = studentFromDTO(new Student(), studentDTO);
        return studentRepository.saveAndFlush(student);
    }

    @Override
    public Student update(StudentDTO studentDTO, Integer id) {
        Student student = studentFromDTO(this.findOneById(id), studentDTO);
        return studentRepository.saveAndFlush(student);
    }

    @Override
    public Student findOneById(Integer id) {
        return studentRepository
                .findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public void delete(Student student) {
        if (student != null) {
            studentRepository.delete(student);
        }
    }

    @Override
    public List<Student> list() {
        return studentRepository.findAll();
    }

    public Student studentFromDTO(Student student, StudentDTO studentDTO) {
        student.setName(studentDTO.getName());
        student.setIsAlive(studentDTO.isAlive());
        student.setYearOfBirth(studentDTO.getYearOfBirth());
        student.setHouse(houseService.findOneById(studentDTO.getHouseId()));
        student.setSlug("");
        return student;
    }
}