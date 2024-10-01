package fr.human.booster.HarryPotter.controllerRest;

import fr.human.booster.HarryPotter.entity.User;
import fr.human.booster.HarryPotter.response.JwtResponse;
import fr.human.booster.HarryPotter.security.JwtAuthenticatorService;
import fr.human.booster.HarryPotter.service.UserService;
import fr.human.booster.HarryPotter.dto.UserLoginDTO;
import fr.human.booster.HarryPotter.dto.UserCreateDTO;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class SecurityController {

    private final UserService userService;
    private final JwtAuthenticatorService jwtAuthenticatorService;

    @PostMapping("/register")
    public User updateSecurityById(@Valid @RequestBody UserCreateDTO dto) {
        return userService.create(dto);
    }

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> securityService(@Valid @RequestBody UserLoginDTO dto) {
        return jwtAuthenticatorService.authenticate(dto);
    }
}