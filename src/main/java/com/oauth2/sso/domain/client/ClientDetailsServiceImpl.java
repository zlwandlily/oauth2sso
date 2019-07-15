package com.oauth2.sso.domain.client;

import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;

/**
 * @Classname ClientDetailsServiceImpl
 * @Description
 * @Date 2019/7/15 15:06
 * @Created by ZLW
 * @Author zlw
 */
public class ClientDetailsServiceImpl implements ClientDetailsService {
  @Override
  public ClientDetails loadClientByClientId(String s) throws ClientRegistrationException {
    return null;
  }
}
