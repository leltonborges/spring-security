package com.web.jwt.webjwt.model.enus;

import com.web.jwt.webjwt.model.exceptions.ProfileNotFoundException;

import java.util.Arrays;

public enum Profile {
    OPERATOR(1, "ROLE_OPERATOR"),
    MANAGER(2, "ROLE_MANAGER"),
    CLIENT(3, "ROLE_CLIENT");

    private Integer id;
    private String name;

    Profile(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Profile fromProfile(Integer idProfile){
        for(Profile p: Profile.values()){
            if(p.getId().equals(idProfile))
                return  p;
        }
        throw new ProfileNotFoundException("Not found profile, id: "+ idProfile);
    }
}
