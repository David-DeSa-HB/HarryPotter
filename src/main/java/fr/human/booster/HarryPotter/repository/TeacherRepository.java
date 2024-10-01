package fr.human.booster.HarryPotter.repository;

import fr.human.booster.HarryPotter.entity.Teacher;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {

    Optional<Teacher> findByNameContainingIgnoreCase(String search);
}