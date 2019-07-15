package com.oauth2.sso.domain.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @Classname Role
 * @Description 角色信息
 * @Date 2019/7/15 15:02
 * @Created by ZLW
 * @Author zlw
 */
@Data
@Entity(name = "role")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Role {

  /**
   * 主键
   * */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  /**
   * 角色编码
   * */
  @Column
  private String roleCode;

  /**
   * 角色名称
   * */
  private String roleName;
}
