package fr.human.booster.HarryPotter.repository;

import fr.human.booster.HarryPotter.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    public User loadUserByUsername(String username);

}