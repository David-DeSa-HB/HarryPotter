package fr.human.booster.HarryPotter.service;

import fr.human.booster.HarryPotter.DTO.HouseDTO;
import fr.human.booster.HarryPotter.entity.House;
import fr.human.booster.HarryPotter.repository.HouseRepository;
import fr.human.booster.HarryPotter.service.interfaces.ServiceInterface;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HouseService  implements ServiceInterface<House, Integer, HouseDTO> {

    private final HouseRepository houseRepository;

    @Override
    public House create(HouseDTO houseDTO) {
        House house = houseFromDTO(new House(), houseDTO);
        return houseRepository.saveAndFlush(house);
    }

    @Override
    public House update(HouseDTO houseDTO, Integer id) {
        House house = houseFromDTO(this.findOneById(id), houseDTO);
        return houseRepository.saveAndFlush(house);
    }

    @Override
    public House findOneById(Integer id) {
        return houseRepository
                .findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public void delete(House house) {
        houseRepository.delete(house);
    }

    @Override
    public List<House> list() {
        return houseRepository.findAll();
    }

    public House houseFromDTO(House house, HouseDTO houseDTO) {
        house.setHouseName(houseDTO.getHouseName());
        house.setFounderFirstName(houseDTO.getFounderFirstName());
        house.setFounderLastName(houseDTO.getFounderLastName());
        house.setSlug("");
        return house;
    }
}