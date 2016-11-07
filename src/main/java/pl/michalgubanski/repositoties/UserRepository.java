package pl.michalgubanski.repositoties;

import pl.michalgubanski.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by U6041021 on 07/11/2016.
 */
interface UserRepository extends JpaRepository<User, Long> {
}
