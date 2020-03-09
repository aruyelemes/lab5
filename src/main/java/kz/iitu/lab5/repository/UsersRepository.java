package kz.iitu.lab5.repository;

import kz.iitu.lab5.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long>{
    List<Users> findAll();
    Optional<Users> findUsersById(Long id);
    Optional<Users> findUsersByName(String name);
    Optional<Users> findUsersByPosition(String position);
}
