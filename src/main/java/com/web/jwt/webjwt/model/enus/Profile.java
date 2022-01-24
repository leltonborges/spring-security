package com.web.jwt.webjwt.model.enus;

import com.web.jwt.webjwt.model.exceptions.ProfileNotFoundException;

import java.util.Arrays;

public enum Profile {
    ROLE_OPERATOR(1, "OPERATOR"),
    ROLE_MANAGER(2, "MANAGER"),
    ROLE_CLIENT(3, "CLIENT");

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
