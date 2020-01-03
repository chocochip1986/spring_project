package com.guozheng.configuration;

import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetailsService;

public class OppenheimerDaoAuthProvider extends DaoAuthenticationProvider {
    private UserDetailsService userDetailsService;

    public OppenheimerDaoAuthProvider(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    public UserDetailsService getUserDetailsService() {
        return this.userDetailsService;
    }

    public void setUserDetailsService(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }
}
