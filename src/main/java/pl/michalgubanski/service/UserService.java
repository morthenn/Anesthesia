package pl.michalgubanski.service;


import org.springframework.beans.factory.annotation.Autowired;
import pl.michalgubanski.model.User;
import pl.michalgubanski.repository.UserRepository;


public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findByUserName(String username) {
        return userRepository.findByLogin(username);
    }
    public User addUser(User newUser) {
        return userRepository.save(newUser);
    }

}
