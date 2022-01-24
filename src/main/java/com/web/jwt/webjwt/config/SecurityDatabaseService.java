package com.web.jwt.webjwt.config;

import com.web.jwt.webjwt.model.User;
import com.web.jwt.webjwt.services.UserService;
import org.apache.catalina.UserDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SecurityDatabaseService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userEntity = userService.findByUsername(username);
        System.out.println(userEntity);
        Set<GrantedAuthority> authorities =
                userEntity.getProfiles()
                        .stream()
                        .map(p -> new SimpleGrantedAuthority(p.name()))
                        .collect(Collectors.toSet());

        UserDetails userDetails =
                new org.springframework.security.core.userdetails.User(
                        userEntity.getUsername(), userEntity.getPassword(), authorities);

        return userDetails;
    }
}
