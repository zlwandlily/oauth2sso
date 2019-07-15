package com.oauth2.sso.repository;

import com.oauth2.sso.SsoApplicationTests;
import com.oauth2.sso.domain.client.*;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Classname ClientRepositoryTest
 * @Description
 * @Date 2019/7/15 17:09
 * @Created by ZLW
 * @Author zlw
 */
public class ClientRepositoryTest extends SsoApplicationTests {

  @Autowired
  ResourceRepository resourceRepository;

  @Autowired
  ClientRepository clientRepository;

  @Autowired
  ScopeRepository scopeRepository;


  @Autowired
  PasswordEncoder passwordEncoder;

  @Before
  public void setUp(){
    Scope scope = new Scope(null,"all");
    Scope scope1 = new Scope(null,"read");
    Scope scope2 = new Scope(null,"write");

    List<Scope> list = new ArrayList<>();
    list.add(scope);
    list.add(scope1);
    list.add(scope2);

    scopeRepository.saveAll(list);

    Resource resource = new Resource(null,"demo");
    Resource resource1 = new Resource(null,"test");
    Resource resource2 = new Resource(null,"dev");

    List<Resource> list1 = new ArrayList<>();
    list1.add(resource);
    list1.add(resource1);
    list1.add(resource2);

    resourceRepository.saveAll(list1);

  }

  @Test
  public void saveTest(){
    clientRepository.save(Client.builder()
    .clientId("zlw")
    .clientSecret(passwordEncoder.encode("zlw"))
    .authorities("ADMIN,USER,SUPERADMIN")
    .authorizedGrantTypes("authorization_code,password,client_credentials,refresh_token,implicit")
    .resources(resourceRepository.findAll().stream().collect(Collectors.toSet()))
    .scopes(scopeRepository.findAll().stream().collect(Collectors.toSet()))
    .accessTokenValiditySeconds(600L)
    .refreshTokenValiditySeconds(3600L)
    .registeredRedirectUri("http://loaclhost:8081/callback")
    .secretRequired(true)
    .scoped(true)
    .build());
  }
}
