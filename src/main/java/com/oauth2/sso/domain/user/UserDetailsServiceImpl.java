package com.oauth2.sso.domain.user;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @Classname UserDetailsServiceImpl
 * @Description 用于实现用户的获取此处用于添加用户信息
 * @Date 2019/7/15 14:32
 * @Created by ZLW
 * @Author zlw
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
  @Override
  public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
    return null;
  }
}
