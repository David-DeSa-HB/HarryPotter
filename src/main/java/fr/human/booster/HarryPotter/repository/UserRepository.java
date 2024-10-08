package fr.human.booster.HarryPotter.repository;

import fr.human.booster.HarryPotter.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    Optional<User> findByEmail(String email);

    Optional<User> findUserByActivationCode(String activationCode);

    Optional<User> findUserByEmailAndActivationCodeIsNull(String email);
}