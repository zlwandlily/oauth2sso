package com.oauth2.sso.domain.client;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @Classname Scope
 * @Description
 * @Date 2019/7/15 16:13
 * @Created by ZLW
 * @Author zlw
 */
@Entity(name = "scope")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Scope {

  /**
   * 主键
   * */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  /**
   * 资源名称
   * */
  @Column(name = "scope_name")
  private String scopeName;
}
