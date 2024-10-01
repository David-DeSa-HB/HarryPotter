package fr.human.booster.HarryPotter.service;

import fr.human.booster.HarryPotter.dto.RoleDTO;
import fr.human.booster.HarryPotter.entity.Role;
import fr.human.booster.HarryPotter.exception.CustomEntityNotFoundException;
import fr.human.booster.HarryPotter.repository.RoleRepository;
import fr.human.booster.HarryPotter.service.interfaces.ServiceCDInterface;
import fr.human.booster.HarryPotter.service.interfaces.ServiceListInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RoleService implements ServiceListInterface <Role, Integer>, ServiceCDInterface <Role, RoleDTO> {

    private final RoleRepository roleRepository;

    @Override
    public Role findOneById(Integer id) {
        return roleRepository
                .findById(id)
                .orElseThrow(CustomEntityNotFoundException::new);
    }

    @Override
    public List<Role> list() {
        return roleRepository.findAll();
    }

    @Override
    public Role create(RoleDTO dto) {
        Role role = RoleFromDTO(new Role(), dto);
        return roleRepository.saveAndFlush(role);
    }

    @Override
    public void delete(Role role) {
        roleRepository.delete(role);
    }


    public Role findBySearch(String search) {
        Optional<Role> optional;
        try {
            optional = roleRepository.findById(Integer.parseInt(search));
        } catch (NumberFormatException e) {
            optional = roleRepository.findByLabelContainingIgnoreCase(search);
        }
        return optional.orElseThrow(CustomEntityNotFoundException::new);
    }

    public Role RoleFromDTO(Role role, RoleDTO dto) {
        role.setLabel(dto.getLabel());
        return role;
    }

}