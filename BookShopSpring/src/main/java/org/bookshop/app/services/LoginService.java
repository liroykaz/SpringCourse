package org.bookshop.app.services;

import org.apache.log4j.Logger;
import org.bookshop.web.dto.LoginForm;
import org.bookshop.web.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private Logger logger = Logger.getLogger(LoginService.class);
    private final ProjectRepository<User> userRepository;

    @Autowired
    public LoginService(ProjectRepository<User> userRepository) {
        this.userRepository = userRepository;
    }

    public boolean register(User user) {
        userRepository.store(user);
        return true;
    }

    public boolean authenticate(LoginForm loginForm) {
        for (User user : userRepository.retreiveAll()) {
            if (user.getUsername().equals(loginForm.getUsername()) && user.getPassword().equals(loginForm.getPassword())) {
                return true;
            }
        }

        return false;
    }
}
