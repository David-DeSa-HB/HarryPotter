package fr.human.booster.HarryPotter.repository;

import fr.human.booster.HarryPotter.entity.HousePoint;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface HousePointRepository extends JpaRepository<HousePoint, Integer> {

}