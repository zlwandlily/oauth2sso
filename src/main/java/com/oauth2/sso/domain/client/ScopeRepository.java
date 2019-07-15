package com.oauth2.sso.domain.client;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Classname ScopeRepository
 * @Description
 * @Date 2019/7/15 17:10
 * @Created by ZLW
 * @Author zlw
 */
public interface ScopeRepository extends JpaRepository<Scope,Long> {
}
