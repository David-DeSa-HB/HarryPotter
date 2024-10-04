package fr.human.booster.HarryPotter.repository;

import fr.human.booster.HarryPotter.entity.House;
import fr.human.booster.HarryPotter.entity.HouseHistory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HouseHistoryRepository extends JpaRepository<HouseHistory, Integer> {

    Optional<House> findByOldHouseNameContainsIgnoreCase(String search);
}