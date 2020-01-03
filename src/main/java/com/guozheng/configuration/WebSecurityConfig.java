package com.guozheng.configuration;

import com.guozheng.services.OppenheimerUserDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Slf4j
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

//    @Autowired
//    public UserDetailsService oppenheimerUserDetailsService;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
        log.info("Configuring authentication information...");
//        builder.userDetailsService(oppenheimerUserDetailsService).passwordEncoder(passwordEncoder());
//        builder.userDetailsService(userDetailsService());
        builder.inMemoryAuthentication().withUser("user").password("{noop}password").roles("USER");
//        builder.authenticationProvider(daoAuthenticationProvider());
//        builder.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery(getUserQuery());
    }

//    @Bean
//    public DaoAuthenticationProvider daoAuthenticationProvider(){
//        DaoAuthenticationProvider oppenheimerDaoAuthProvider = new OppenheimerDaoAuthProvider(oppenheimerUserDetailsService);
//        return oppenheimerDaoAuthProvider;
//    }

    @Bean
    @Qualifier("oppenheimerUserDetailsService")
    public UserDetailsService userDetailsService() {
        return new OppenheimerUserDetailsService();
    }

//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()
                .antMatchers("/", "/home").access("hasRole('USER')")
                .and()
                /*.permitAll()
                .anyRequest()
                .authenticated()
                .and()*/
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }

//    @Bean
//    @Override
//    public UserDetailsService userDetailsService() {
//        UserDetails user = User.withDefaultPasswordEncoder()
//                .username("admin")
//                .password("admin")
//                .roles("admin")
//                .build();
//
//        return new InMemoryUserDetailsManager(user);
//    }

    private String getUserQuery() {
        return "SELECT USERNAME, PASSWORD, ENABLED FROM USER WHERE USERNAME = ?";
    }
}
