package pl.michalgubanski.service;


import org.springframework.beans.factory.annotation.Autowired;
import pl.michalgubanski.model.User;
import pl.michalgubanski.repository.UserRepository;

import java.util.List;

/**
 * Created by U6041021 on 07/11/2016.
 */
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findByUserName(String username) {
        return userRepository.findByLogin(username);
    }
}
