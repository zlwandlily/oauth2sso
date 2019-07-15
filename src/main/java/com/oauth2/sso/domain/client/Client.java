package com.oauth2.sso.domain.client;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

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
   * 回调地址,支持多个，需要“,”隔开
   * */
  @Column(name = "redirect_uri")
  private String registeredRedirectUri;

  /**
   * token有效时间
   * */
  @Column(name = "access_token_validity_seconds")
  private Long accessTokenValiditySeconds;

  /**
   * 支持的验证类型,支持多个，需要“,”隔开
   * */
  @Column(name = "authorized_granttype")
  private String authorizedGrantTypes;

  /**
   * 支持的角色类型,支持多个，需要“,”隔开
   * */
  @Column
  private String authorities;

  /**
   * token刷新有效时间
   * */
  @Column(name = "refresh_token_validity_seconds")
  private Long refreshTokenValiditySeconds;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "client_to_resource",joinColumns = {@JoinColumn(name = "client_id")},
  inverseJoinColumns = {@JoinColumn(name = "resource_id")})
  private Set<Resource> resources;


  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "client_to_scope",joinColumns = {@JoinColumn(name = "client_id")},
      inverseJoinColumns = {@JoinColumn(name = "scope_id")})
  private Set<Scope> scopes;


}
