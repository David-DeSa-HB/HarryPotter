package fr.human.booster.HarryPotter.configuration;

import fr.human.booster.HarryPotter.entity.Role;
import fr.human.booster.HarryPotter.entity.User;
import fr.human.booster.HarryPotter.repository.RoleRepository;
import fr.human.booster.HarryPotter.repository.UserRepository;
import lombok.AllArgsConstructor;
import net.datafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Component
@AllArgsConstructor
public class InitDataLoaderConfig implements CommandLineRunner {

    private BCryptPasswordEncoder passwordEncoder;
    private UserRepository userRepository;
    private RoleRepository roleRepository;

    @Override
    public void run(String... args) {
        createRoles();
        createUsers();
    }

    private void createRoles() {
        if (roleRepository.count() == 0) {
            Role role = new Role();
            role.setLabel("ROLE_USER");
            roleRepository.saveAndFlush(role);

            Role admin = new Role();
            admin.setLabel("ROLE_ADMIN");
            roleRepository.saveAndFlush(admin);
        }
    }

    private void createUsers() {
        Faker faker = new Faker(Locale.of("fr"));
        List<String> duplicates = new ArrayList<>();
        Long count = 50 - userRepository.count();
        for (long i = 1L; i <= count; i++) {
            User user = new User();
            String name;
            do {
                name = faker.name().name().replace(" ", "");
            } while (duplicates.contains(name));
            duplicates.add(name);
            user.setNickname(name);
            user.setPassword(passwordEncoder.encode("12345*"));
            user.setCreatedAt(generateRandomDate());
            user.setEmail(name + "@toto.toto");

            Role userRole = roleRepository.findById(1).get();
            if (i == 1L) {
                Role admin = roleRepository.findById(2).get();
                user.setRoles(List.of(admin, userRole));
            } else {
                user.setRoles(List.of(userRole));
            }
            userRepository.save(user);
        }
        Role userRole = new Role();
        Role adminRole = new Role();
        userRole.setLabel("ROLE_USER");
        adminRole.setLabel("ROLE_ADMIN");
    }

    private LocalDateTime generateRandomDate() {
        Faker faker = new Faker();
        Instant randomDate = faker.timeAndDate().between(
                Instant.now().minusMillis(999999999),
                Instant.now());
        return randomDate.atZone(ZoneId.systemDefault()).toLocalDateTime();
    }
}
