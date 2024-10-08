package fr.human.booster.HarryPotter.repository;

import fr.human.booster.HarryPotter.entity.Subject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer> {

    Optional<Subject> findBySubjectNameContainingIgnoreCase(String search);
}