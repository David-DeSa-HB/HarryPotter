package fr.human.booster.HarryPotter.repository;

import fr.human.booster.HarryPotter.entity.Offense;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OffenseRepository extends JpaRepository<Offense, Integer> {

}