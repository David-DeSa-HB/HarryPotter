package fr.human.booster.HarryPotter.repository;

import fr.human.booster.HarryPotter.entity.OffenseList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OffenseListRepository extends JpaRepository<OffenseList, Integer> {

}