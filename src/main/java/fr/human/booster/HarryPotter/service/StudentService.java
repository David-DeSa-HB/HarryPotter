package fr.human.booster.HarryPotter.service;

import fr.human.booster.HarryPotter.DTO.StudentCreateDTO;
import fr.human.booster.HarryPotter.entity.Student;
import fr.human.booster.HarryPotter.repository.StudentRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    private final HouseService houseService;

    public Student create(StudentCreateDTO studentDTO) {
        Student student = studentFromDTO(new Student(), studentDTO);
        return studentRepository.saveAndFlush(student);
    }
    public Student update(StudentCreateDTO studentDTO, int id) {
        Student student = this.getOneById(id);
        student.setName(studentDTO.getName());
        student.setAlive(studentDTO.isAlive());
        student.setYearOfBirth(studentDTO.getYearOfBirth());
        return studentRepository.saveAndFlush(student);
    }

    public Student getOneById(int id) {
        return studentRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public void delete(Student student) {
        studentRepository.delete(student);
    }

    public List<Student> list() {
        return studentRepository.findAll();
    }

    public Student studentFromDTO(Student student, StudentCreateDTO studentDTO) {
        student.setName(studentDTO.getName());
        student.setAlive(studentDTO.isAlive());
        student.setYearOfBirth(studentDTO.getYearOfBirth());
        student.setHouse(houseService.getOneById(studentDTO.getHouseId()));
        student.setSlug("");
        return student;
    }
}