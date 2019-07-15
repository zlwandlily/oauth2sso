package com.oauth2.sso.domain.client;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @Classname Resource
 * @Description
 * @Date 2019/7/15 16:01
 * @Created by ZLW
 * @Author zlw
 */
@Entity(name = "resource")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Resource {

  /**
   * 主键
   * */
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  /**
   * 资源名称
   * */
  @Column(name = "resource_name")
  private String resourceName;
}
