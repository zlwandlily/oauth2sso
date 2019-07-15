package com.oauth2.sso.config.oauth2server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

/**
 * @Classname Oauth2AuthorizationConfig
 * @Description
 * @Date 2019/7/15 10:25
 * @Created by ZLW
 * @Author zlw
 */
@Configuration
@EnableAuthorizationServer
public class Oauth2AuthorizationConfig extends AuthorizationServerConfigurerAdapter {

  @Autowired
  UserDetailsService userDetailsServiceImpl;

  @Autowired
  AuthenticationManager authenticationManager;

  @Autowired
  PasswordEncoder passwordEncoder;

  @Autowired
  ClientDetailsService clientDetailsServiceImpl;

  @Override
  public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
    //配置两个客户端,一个用于password认证一个用于client认证,此处使用的是内存模式
//    clients.inMemory().withClient("client_1")
//        .resourceIds("demo")
//        .authorizedGrantTypes("client_credentials", "refresh_token")
//        .scopes("all")
//        .authorities("client")
//        .secret(passwordEncoder.encode("123456"))
//        .and().withClient("client_2")
//        .resourceIds("demo")
//        .authorizedGrantTypes("password", "refresh_token")
//        .scopes("all")
//        .authorities("client")
//        .secret(passwordEncoder.encode("123456"));
    // 此处使用的是数据库模式
    clients.withClientDetails(clientDetailsServiceImpl);
  }

  @Override
  public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
    endpoints
        .tokenStore(new InMemoryTokenStore())
        .authenticationManager(authenticationManager)
        .userDetailsService(userDetailsServiceImpl);
  }

  @Override
  public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
    //允许表单认证
    oauthServer.allowFormAuthenticationForClients();
  }


}
