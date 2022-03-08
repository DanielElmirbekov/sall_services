package it_schoolkg.sall_services.repository.dao;

import it_schoolkg.sall_services.Models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User,Long> {
    User findByLogin(String login);
}
