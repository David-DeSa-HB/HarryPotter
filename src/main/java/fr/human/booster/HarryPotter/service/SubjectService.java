package fr.human.booster.HarryPotter.service;

import fr.human.booster.HarryPotter.DTO.SubjectDTO;
import fr.human.booster.HarryPotter.entity.Subject;
import fr.human.booster.HarryPotter.repository.SubjectRepository;
import fr.human.booster.HarryPotter.service.interfaces.ServiceInterface;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SubjectService implements ServiceInterface<Subject, Integer, SubjectDTO> {

    private SubjectRepository subjectRepository;

    @Override
    public Subject create(SubjectDTO subjectDTO) {
        Subject subject = subjectFromDTO(new Subject(), subjectDTO);
        return subjectRepository.saveAndFlush(subject);
    }

    @Override
    public Subject update(SubjectDTO subjectDTO, Integer id) {
        Subject subject = subjectFromDTO(this.findOneById(id), subjectDTO);
        return subjectRepository.saveAndFlush(subject);
    }

    @Override
    public Subject findOneById(Integer id) {
        return subjectRepository
                .findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public void delete(Subject subject) {
        if (subject != null) {
            subjectRepository.delete(subject);
        }
    }

    @Override
    public List<Subject> list() {
        return subjectRepository.findAll();
    }

    public Subject subjectFromDTO(Subject subject, SubjectDTO subjectDTO) {
        subject.setSubjectName(subjectDTO.getName());
        subject.setSlug("");
        return subject;
    }
}