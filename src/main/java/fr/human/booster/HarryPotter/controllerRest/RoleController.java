package fr.human.booster.HarryPotter.controllerRest;

import fr.human.booster.HarryPotter.entity.Role;
import fr.human.booster.HarryPotter.service.RoleService;
import fr.human.booster.HarryPotter.dto.RoleDTO;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/role")
@AllArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @GetMapping()
    public List<Role> List() {
        return roleService.list();
    }

    @GetMapping("/{search}")
    public Role findRoleBySearch(@PathVariable String search) {
        return roleService.findBySearch(search);
    }

    @PostMapping
    public Role createRole(@Valid @RequestBody RoleDTO dto) {
        return roleService.create(dto);
    }

    @DeleteMapping("/{id}")
    public void deleteRoleByID(@PathVariable Integer id) {
        if (id != null) {
            roleService.delete(roleService.findOneById(id));
        }
    }


}