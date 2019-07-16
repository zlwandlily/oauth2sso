package com.oauth2.sso.repository;

import com.oauth2.sso.SsoApplicationTests;
import com.oauth2.sso.domain.user.Role;
import com.oauth2.sso.domain.user.RoleRepository;
import com.oauth2.sso.domain.user.User;
import com.oauth2.sso.domain.user.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Classname UserRepositoryTest
 * @Description
 * @Date 2019/7/15 16:35
 * @Created by ZLW
 * @Author zlw
 */
public class UserRepositoryTest  extends SsoApplicationTests {

  @Autowired
  UserRepository userRepository;

  @Autowired
  RoleRepository roleRepository;

  @Autowired
  PasswordEncoder passwordEncoder;

  @Before
  public void setUp(){
    Role role = new Role(null,"ADMIN","管理员");
    Role role1 = new Role(null,"USER","普通用户");
    Role role2 = new Role(null,"SUPERADMIN","超级管理员");

    List<Role> list = new ArrayList<>();
    list.add(role);
    list.add(role1);
    list.add(role2);

    roleRepository.saveAll(list);

  }

  @Test
  public void saveTest(){
    userRepository.save(User.builder()
        .userName("admin")
        .passWord(passwordEncoder.encode("admin"))
        .accountNonExpired(true)
        .accountNonLocked(true)
        .credentialsNonExpired(true)
        .enabled(true)
        .salt("使用默认加密，不需要存储密码盐")
        .roles(roleRepository.findAll().stream().collect(Collectors.toSet()))
        .build());
  }
}
