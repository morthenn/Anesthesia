package pl.michalgubanski.repository;

import org.springframework.stereotype.Repository;
import pl.michalgubanski.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by U6041021 on 07/11/2016.
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByLogin(String login);
}
