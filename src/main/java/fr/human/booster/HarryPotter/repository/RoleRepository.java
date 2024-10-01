package fr.human.booster.HarryPotter.repository;

import fr.human.booster.HarryPotter.entity.Role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    Optional<Role> findByLabelContainingIgnoreCase(String search);
}