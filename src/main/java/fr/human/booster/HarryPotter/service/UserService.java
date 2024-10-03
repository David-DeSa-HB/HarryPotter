package fr.human.booster.HarryPotter.service;

import fr.human.booster.HarryPotter.dto.UserCreateDTO;
import fr.human.booster.HarryPotter.dto.UserUpdateDTO;
import fr.human.booster.HarryPotter.entity.Role;
import fr.human.booster.HarryPotter.exception.CustomEntityNotFoundException;
import fr.human.booster.HarryPotter.repository.UserRepository;
import fr.human.booster.HarryPotter.entity.User;
import fr.human.booster.HarryPotter.service.interfaces.ServiceCUDInterface;
import fr.human.booster.HarryPotter.service.interfaces.ServiceGetInterface;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
@AllArgsConstructor
public class UserService implements ServiceGetInterface<User, String>, ServiceCUDInterface<User, UserCreateDTO, UserUpdateDTO, String>, UserDetailsService {

    private final UserRepository userRepository;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User findOneById(String id) {
        return userRepository
                .findById(id)
                .orElseThrow(CustomEntityNotFoundException::new);
    }

    @Override
    public User create(UserCreateDTO dto) {
        User user = getUserFromUserCreateDTO(new User(), dto);
        return userRepository.saveAndFlush(user);
    }

    @Override
    public User update(UserUpdateDTO dto, String id) {
        User user = getUserFromUserUpdateDTO(this.findOneById(id), dto);
        return userRepository.saveAndFlush(user);
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

    private User getUserFromUserCreateDTO(User user, UserCreateDTO dto) {
        user.setNickname(dto.getNickname());
        user.setEmail(dto.getEmail());
        user.setPassword(passwordEncoder.encode(dto.getPassword()));
        user.setCreatedAt(LocalDateTime.now());
        List<Role> roleList = new ArrayList<>();
        roleList.add(roleService.findOneById(1));
        user.setRoles(roleList);
        return user;
    }

    private User getUserFromUserUpdateDTO(User user, UserUpdateDTO dto) {
        List<Role> userRoles = user.getRoles();
        userRoles.add(roleService.findOneById(dto.getRoleId()));
        user.setRoles(userRoles);
        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Connexion Impossible"));

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                getGrantedAuthority(user.getRoles())
        );
    }

    private Collection<? extends GrantedAuthority> getGrantedAuthority(List<Role> roles) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        System.out.println("roles = " + roles);
        roles.forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getLabel())));
        System.out.println("authorities = " + authorities);
        return authorities;
    }
}