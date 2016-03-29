package main.oracle.academy.fp.service.impl;

import main.oracle.academy.fp.model.User;
import main.oracle.academy.fp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserAuthenticationService implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userService.getByLogin(s);
        Set<GrantedAuthority> roles = new HashSet();
        roles.add(new SimpleGrantedAuthority(user.getRole().toString()));

        return new org.springframework.security.core.userdetails.User(user.getLogin(),
                user.getPassword(),
                roles);
    }

    public User getCurrentUser ()  {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetails currentUserDetails = (UserDetails) principal;
        return userService.getByLogin(currentUserDetails.getUsername());
    }

    public User getCurrentUserWithJoins() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        UserDetails currentUserDetails = (UserDetails) principal;
        return userService.getByLoginWithJoins(currentUserDetails.getUsername());
    }
}
