package com.guozheng.services;

import com.guozheng.authentication.OppenheimerUserDetails;
import com.guozheng.dao.UserDao;
import com.guozheng.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class OppenheimerUserDetailsService implements UserDetailsService {
    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userDao.findByUsername(username);

        org.springframework.security.core.userdetails.User.UserBuilder builder = null;
        if ( user == null ){
            throw new UsernameNotFoundException(username);
        }
        builder = org.springframework.security.core.userdetails.User.withUsername(user.getUsername());
        builder.password(user.getPassword());
        builder.roles(new String[]{"USER"});
        return builder.build();
    }
}
