package com.web.jwt.webjwt.services;

import com.web.jwt.webjwt.model.User;
import com.web.jwt.webjwt.repositories.UserRepository;
import com.web.jwt.webjwt.services.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.Optional;

@Service
public class UserService implements Serializable {
    private static final long serialVersionUID = -1275585662187895814L;

    @Autowired
    private UserRepository userRepository;

    public User findByUsername(String name) {
        return userRepository
                .findByUsername(name)
                .orElseThrow(() -> new UserNotFoundException("Not found userName: " + name));
    }

    public <S extends User> S save(S entity) {
        return userRepository.save(entity);
    }
}
