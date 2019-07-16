package com.oauth2.sso.config.oauth2web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @Classname WebSecurityConfigurer
 * @Description
 * @Date 2019/7/15 11:30
 * @Created by ZLW
 * @Author zlw
 */
@Configuration
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {

  @Autowired
  UserDetailsService userDetailsServiceImpl;

  @Bean
  @Override
  public AuthenticationManager authenticationManagerBean() throws Exception {
    return super.authenticationManagerBean();
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {

    http.formLogin().and()
        .requestMatchers()
        .antMatchers("/login","/oauth/authorize")
        .and()
        .authorizeRequests()
        .anyRequest()
        .authenticated();
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userDetailsServiceImpl);
  }
  
}
