package fr.human.booster.HarryPotter.service;

import fr.human.booster.HarryPotter.dto.HouseDTO;
import fr.human.booster.HarryPotter.entity.House;
import fr.human.booster.HarryPotter.exception.CustomEntityNotFoundException;
import fr.human.booster.HarryPotter.repository.HouseRepository;
import fr.human.booster.HarryPotter.service.interfaces.ServiceCUDInterface;
import fr.human.booster.HarryPotter.service.interfaces.ServiceListInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class HouseService implements ServiceListInterface<House, Integer>, ServiceCUDInterface<House, HouseDTO, HouseDTO, Integer> {

    private final HouseRepository houseRepository;


    @Override
    public House update(HouseDTO houseDTO, Integer id) {
        House house = houseFromDTO(this.findOneById(id), houseDTO);
        return houseRepository.saveAndFlush(house);
    }

    @Override
    public House create(HouseDTO houseDTO) {
        House house = houseFromDTO(new House(), houseDTO);
        return houseRepository.saveAndFlush(house);
    }

    @Override
    public void delete(House house) {
        houseRepository.delete(house);
    }

    @Override
    public List<House> list() {
        return houseRepository.findAll();
    }

    @Override
    public House findOneById(Integer id) {
        return houseRepository
                .findById(id)
                .orElseThrow(CustomEntityNotFoundException::new);
    }

    public House findBySearch(String search) {
        Optional<House> optional;
        try {
            optional = houseRepository.findById(Integer.parseInt(search));
        } catch (NumberFormatException e) {
            optional = houseRepository.findByHouseNameContainingIgnoreCase(search);
        }
        return optional.orElseThrow(CustomEntityNotFoundException::new);
    }

    public House houseFromDTO(House house, HouseDTO houseDTO) {
        house.setHouseName(houseDTO.getHouseName());
        house.setFounderFirstName(houseDTO.getFounderFirstName());
        house.setFounderLastName(houseDTO.getFounderLastName());
        house.setSlug("");
        return house;
    }
}