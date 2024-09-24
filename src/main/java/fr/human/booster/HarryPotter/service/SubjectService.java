package fr.human.booster.HarryPotter.service;

import fr.human.booster.HarryPotter.repository.SubjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SubjectService {

    private final SubjectRepository subjectRepository;



}