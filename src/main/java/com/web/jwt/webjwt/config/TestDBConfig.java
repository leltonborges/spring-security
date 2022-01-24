package com.web.jwt.webjwt.config;

import com.web.jwt.webjwt.model.User;
import com.web.jwt.webjwt.model.enus.Profile;
import com.web.jwt.webjwt.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Set;

@Component
public class TestDBConfig implements CommandLineRunner {
    @Autowired
    private UserRepository userRepository;

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        User lia = new User(null, "lia", "123", Set.of(Profile.ROLE_CLIENT, Profile.ROLE_OPERATOR));
        User bob = new User(null, "bob", "123", Set.of(Profile.ROLE_CLIENT, Profile.ROLE_MANAGER));

        userRepository.save(lia);
        userRepository.save(bob);

    }
}
