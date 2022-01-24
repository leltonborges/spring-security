package com.web.jwt.webjwt.model;

import com.web.jwt.webjwt.model.enus.Profile;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "tb_user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false)
    private String username;
    @Column(unique = true, nullable = false)
    private String password;

    @CollectionTable(name = "tb_profile_user")
    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING )
    private Set<Profile> profiles = new HashSet<>();
}
