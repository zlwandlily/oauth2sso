package com.oauth2.sso.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Classname UserResportity
 * @Description
 * @Date 2019/7/15 14:52
 * @Created by ZLW
 * @Author zlw
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long> {


}
