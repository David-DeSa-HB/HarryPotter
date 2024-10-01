package fr.human.booster.HarryPotter.repository;

import fr.human.booster.HarryPotter.entity.TypeOfClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeOfClassRepository extends JpaRepository<TypeOfClass, Integer> {
}