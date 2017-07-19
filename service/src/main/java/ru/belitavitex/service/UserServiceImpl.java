package ru.belitavitex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.belitavitex.dao.PersonDao;
import ru.belitavitex.entity.Person;
import ru.belitavitex.entity.User;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Dzianis on 29.06.2017.
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final PersonDao personDao;

    @Autowired
    public UserServiceImpl(PersonDao personDao) {
        this.personDao = personDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Person person = personDao.findByEmail(username);
        if (person == null) {
            throw new UsernameNotFoundException("Can't find user by provided E-mail!");
        }
        return new User(person.getId(), person.fullName(), person.getEmail(),
                person.getPassword(), getUserAuthorities(person));
    }

    private Set<GrantedAuthority> getUserAuthorities(Person person) {
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(person.getGroups().toString()));
        return grantedAuthorities;
    }
}
