package ru.belitavitex.entity;


import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;

/**
 * Created by Dzianis on 29.06.2017.
 */
public class User extends org.springframework.security.core.userdetails.User {

    @Setter
    @Getter
    private String fullName;

    public User(String fullName, String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.fullName = fullName;
    }

}
