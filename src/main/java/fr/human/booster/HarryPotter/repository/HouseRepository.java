package fr.human.booster.HarryPotter.repository;

import fr.human.booster.HarryPotter.entity.House;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseRepository extends JpaRepository<House, Integer> {

}