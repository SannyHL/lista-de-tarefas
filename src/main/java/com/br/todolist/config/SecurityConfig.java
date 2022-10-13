package com.br.todolist.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class SecurityConfig extends WebSecurityConfigurerAdapter{
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
        .cors()
        .and()
        .httpBasic()
        .and()
        .authorizeRequests().antMatchers("/task**").permitAll().anyRequest().authenticated();
    }
}
