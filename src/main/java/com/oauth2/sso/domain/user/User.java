package com.oauth2.sso.domain.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

/**
 * @Classname User
 * @Description
 * @Date 2019/7/15 14:44
 * @Created by ZLW
 * @Author zlw
 */
@Entity(name = "user")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
  /**
   * 主键，自增
   * */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  /**
   * 用户名
   * */
  @Column(name = "user_name",length = 80,unique = true)
  private String userName;
  /**
   * 用户密码
   * */
  @Column(name = "password", length = 200)
  private String passWord;
  /**
   * 加盐
   * */
  @Column(length = 60)
  private String salt;

  /**
   * 用户是否过时
   * */
  @Column(name = "account_expired")
  private boolean accountNonExpired;

  /**
   * 用户是否锁定
   * */
  @Column(name = "account_locked")
  private boolean accountNonLocked;

  /**
   * 证书是否过期
   * */
  @Column(name = "credentials_expired")
  private boolean credentialsNonExpired;

  /**
   * 用户是否可用
   * */
  @Column
  private boolean enabled;

  @ManyToMany
  @JoinTable(name = "user_to_role",joinColumns = {@JoinColumn(name = "user_id")},
  inverseJoinColumns = {@JoinColumn(name = "role_id")})
  private Set<Role> roles;


}
