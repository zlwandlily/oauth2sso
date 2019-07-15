package com.oauth2.sso.domain.client;

import lombok.AllArgsConstructor;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Service;

/**
 * @Classname ClientDetailsServiceImpl
 * @Description
 * @Date 2019/7/15 15:06
 * @Created by ZLW
 * @Author zlw
 */
@Service
@AllArgsConstructor
public class ClientDetailsServiceImpl implements ClientDetailsService {

  ClientRepository clientRepository;

  @Override
  public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
    Client client = clientRepository.findFirstByClientId(clientId);
    return ClientMysqlDetails.builder()
        .client(client)
        .build();
  }
}
