package com.oauth2.sso.config.oauth2web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @Classname WebSecurityConfigurer
 * @Description
 * @Date 2019/7/15 11:30
 * @Created by ZLW
 * @Author zlw
 */
@Configuration
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {
  @Bean
  @Override
  public AuthenticationManager authenticationManagerBean() throws Exception {
    return super.authenticationManagerBean();
  }

  
}
