package fr.human.booster.HarryPotter.controllerRest;

import fr.human.booster.HarryPotter.dto.UserUpdateDTO;
import fr.human.booster.HarryPotter.entity.User;
import fr.human.booster.HarryPotter.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    public User findUserById(@PathVariable String id) {
        return userService.findOneById(id);
    }

    @PutMapping("/{id}")
    public void updateUserById(
            @PathVariable String id,
            @Valid @RequestBody UserUpdateDTO dto) {
        if (id != null) {
            userService.update(dto, id);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteUserByID(@PathVariable String id) {
        if (id != null) {
            userService.delete(userService.findOneById(id));
        }
    }
}