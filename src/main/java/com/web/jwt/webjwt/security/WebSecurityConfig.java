package com.web.jwt.webjwt.security;

import com.web.jwt.webjwt.config.SecurityDatabaseService;
import com.web.jwt.webjwt.model.enus.Profile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final static String[] ROLES_OPERATOR = {Profile.ROLE_OPERATOR.getName()};
    private final static String[] ROLES_MANAGER = {Profile.ROLE_MANAGER.getName()};

    @Autowired
    private SecurityDatabaseService securityDatabaseService;

    @Autowired
    public void globalUserDateils(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(securityDatabaseService)
                .passwordEncoder(NoOpPasswordEncoder.getInstance());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/h2-console/**").permitAll()
                .antMatchers(HttpMethod.POST, "/login").permitAll()
                .antMatchers("/managers").hasAnyRole(ROLES_MANAGER)
                .antMatchers("/users").hasAnyRole(ROLES_OPERATOR)
                .anyRequest().authenticated().and().httpBasic();
    }

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("user")
//                .password("{noop}user123")
//                .roles("USERS")
//                .and()
//                .withUser("admin")
//                .password("{noop}admin123")
//                .roles("MANAGERS", "USERS");
//    }
}
