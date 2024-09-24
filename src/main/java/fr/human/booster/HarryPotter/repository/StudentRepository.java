package fr.human.booster.HarryPotter.repository;

import fr.human.booster.HarryPotter.entity.Student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
}