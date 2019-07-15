package com.oauth2.sso.domain.client;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @Classname Client
 * @Description
 * @Date 2019/7/15 15:05
 * @Created by ZLW
 * @Author zlw
 */
@Entity(name = "client")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Client {

  /**
   * 主键
   * */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  /**
   * 客户端Id
   * */
  @Column(name = "client_id")
  private String clientId;

  @Column(name = "secret_required")
  private boolean secretRequired;

  @Column(name = "client_secret")
  private String clientSecret;

  @Column
  private boolean scoped;

  /**
   * 回调地址
   * */
  @Column(name = "redirect_uri")
  private String registeredRedirectUri;

  /**
   * token有效时间
   * */
  @Column(name = "access_token_validity_seconds")
  private Long accessTokenValiditySeconds;

  /**
   * token刷新有效时间
   * */
  @Column(name = "refresh_token_validity_seconds")
  private Long refreshTokenValiditySeconds;


}
