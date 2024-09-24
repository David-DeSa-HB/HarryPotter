package fr.human.booster.HarryPotter.service;

import fr.human.booster.HarryPotter.entity.House;
import fr.human.booster.HarryPotter.entity.Student;
import fr.human.booster.HarryPotter.repository.HouseRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class HouseService {

    private final HouseRepository houseRepository;

    public House getOneById(int id) {
        return houseRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
}