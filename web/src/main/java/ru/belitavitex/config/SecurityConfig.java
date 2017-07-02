package ru.belitavitex.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.thymeleaf.spring4.SpringTemplateEngine;

/**
 * Created by Dzianis on 22.06.2017.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;

    @Autowired
    public SecurityConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
//                   .anyRequest()
                .antMatchers("/Registration", "/resources/**", "/login", "/login-error")
                .permitAll()
                .antMatchers("/AllPersons")
                .hasAuthority("ADMIN")
                .antMatchers("/**")
                .authenticated()

             .and()
                .formLogin()
                .loginPage("/login")
                .failureUrl("/login-error")
             .and()
                .logout()
                .logoutUrl("/Logout")
                .logoutSuccessUrl("/login")
             .and()
                .csrf().disable()
                .userDetailsService(userDetailsService);
    }


//    private final UserDetailsService userDetailsService;
//
//    @Autowired
//    public SecurityConfig(UserDetailsService userDetailsService) {
//        this.userDetailsService = userDetailsService;
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .antMatchers("/home", "/login")
//                    .permitAll()
//                .antMatchers("/admin")
//                    .hasAuthority("ADMIN")
//                .anyRequest()
//                    .authenticated()
//            .and()
//                .formLogin()
//                .loginPage("/login")
//                .loginProcessingUrl("/login")
//                .defaultSuccessUrl("/home")
//            .and()
//                .logout()
//                .logoutUrl("/logout")
//                .logoutSuccessUrl("/login")
//            .and()
//                .csrf().disable();
//
//        http.userDetailsService(userDetailsService);

//        User user = (User) SecurityContextHolder.getContext()
//                .getAuthentication()
//                .getDetails();

//    }


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
        builder.inMemoryAuthentication().withUser("Admin")
                .password("root").roles("ADMIN");
    }
}
