package com.oauth2.sso.domain.client;

import lombok.Builder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Classname ClientMysqlDetails
 * @Description
 * @Date 2019/7/15 15:08
 * @Created by ZLW
 * @Author zlw
 */
@Builder
public class ClientMysqlDetails implements ClientDetails {

  private Client client;

  @Override
  public String getClientId() {
    return client.getClientId();
  }

  @Override
  public Set<String> getResourceIds() {
    return client.getResources().stream().map(x -> x.getResourceName()).collect(Collectors.toSet());
  }

  @Override
  public boolean isSecretRequired() {
    return client.isSecretRequired();
  }

  @Override
  public String getClientSecret() {
    return client.getClientSecret();
  }

  @Override
  public boolean isScoped() {
    return client.isScoped();
  }

  @Override
  public Set<String> getScope() {
    return client.getScopes().stream().map(x -> x.getScopeName()).collect(Collectors.toSet());
  }

  @Override
  public Set<String> getAuthorizedGrantTypes() {
    return Arrays.stream(client.getAuthorizedGrantTypes().split(",")).collect(Collectors.toSet());
  }

  @Override
  public Set<String> getRegisteredRedirectUri() {
    return Arrays.stream(client.getRegisteredRedirectUri().split(",")).collect(Collectors.toSet());
  }

  @Override
  public Collection<GrantedAuthority> getAuthorities() {
    return Arrays.stream(client.getAuthorities().split(",")).map(x -> (GrantedAuthority) () -> x).collect(Collectors.toSet());
  }

  @Override
  public Integer getAccessTokenValiditySeconds() {
    return Math.toIntExact(client.getAccessTokenValiditySeconds());
  }

  @Override
  public Integer getRefreshTokenValiditySeconds() {
    return Math.toIntExact(client.getRefreshTokenValiditySeconds());
  }

  /**
   * 如果操作符合已存储的操作范围，则自动授权
   * */
  @Override
  public boolean isAutoApprove(String scope) {
    if (this.getScope() == null) {
      return false;
    } else {
      Iterator var2 = this.getScope().iterator();

      String auto;
      do {
        if (!var2.hasNext()) {
          return false;
        }

        auto = (String) var2.next();
      } while (!auto.equals("true") && !scope.matches(auto));
      return true;
    }
  }

  @Override
  public Map<String, Object> getAdditionalInformation() {
    return null;
  }
}
