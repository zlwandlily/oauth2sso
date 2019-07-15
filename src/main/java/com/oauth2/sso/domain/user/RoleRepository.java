package com.oauth2.sso.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Classname RoleRepository
 * @Description
 * @Date 2019/7/15 16:38
 * @Created by ZLW
 * @Author zlw
 */
@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
}
