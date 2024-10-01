package fr.human.booster.HarryPotter.service;

import fr.human.booster.HarryPotter.dto.SubjectDTO;
import fr.human.booster.HarryPotter.entity.Subject;
import fr.human.booster.HarryPotter.exception.CustomEntityNotFoundException;
import fr.human.booster.HarryPotter.repository.SubjectRepository;
import fr.human.booster.HarryPotter.service.interfaces.ServiceCUDInterface;
import fr.human.booster.HarryPotter.service.interfaces.ServiceListInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SubjectService implements ServiceListInterface<Subject, Integer>, ServiceCUDInterface<Subject, SubjectDTO, SubjectDTO, Integer> {

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
                .orElseThrow(CustomEntityNotFoundException::new);
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

    public Subject findBySearch(String search) {
        Optional<Subject> optional;
        try {
            optional = subjectRepository.findById(Integer.parseInt(search));
        } catch (NumberFormatException e) {
            optional = subjectRepository.findBySubjectNameContainingIgnoreCase(search);
        }
        return optional.orElseThrow(CustomEntityNotFoundException::new);
    }

    public Subject subjectFromDTO(Subject subject, SubjectDTO subjectDTO) {
        subject.setSubjectName(subjectDTO.getName());
        subject.setSlug("");
        return subject;
    }
}