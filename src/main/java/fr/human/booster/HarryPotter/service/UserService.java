package fr.human.booster.HarryPotter.service;

import fr.human.booster.HarryPotter.repository.UserRepository;
import fr.human.booster.HarryPotter.dto.UserDTO;
import fr.human.booster.HarryPotter.entity.User;
import fr.human.booster.HarryPotter.service.interfaces.ServiceListInterface;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService implements ServiceListInterface<User, String, UserDTO, UserDTO> {

    private final UserRepository userRepository;

    @Override
    public User findOneById(String id) {
        return userRepository
                .findById(id)
                .orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<User> list() {
        return userRepository.findAll();
    }

    @Override
    public User create(UserDTO dto) {
        User user = UserFromDTO(new User(), dto);
        return userRepository.saveAndFlush(user);
    }

    @Override
    public User update(UserDTO dto, String id) {
        User user = UserFromDTO(this.findOneById(id), dto);
        return userRepository.saveAndFlush(user);
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

    public User UserFromDTO(User user, UserDTO dto) {
        user.set(dto.get);
        return user;
    }

}