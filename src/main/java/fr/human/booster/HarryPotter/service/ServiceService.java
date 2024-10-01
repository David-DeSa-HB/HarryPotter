package fr.human.booster.HarryPotter.service;

import fr.human.booster.HarryPotter.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ServiceService {

    private final UserRepository serviceRepository;

}