package com.oauth2.sso.domain.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @Classname UserToRole
 * @Description
 * @Date 2019/7/15 15:31
 * @Created by ZLW
 * @Author zlw
 */
@Entity(name = "user_to_role")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserToRole {
  /**
   * 主键，自增
   * */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "user_id")
  private Long userId;

  @Column(name = "role_id")
  private Long roleId;
}
