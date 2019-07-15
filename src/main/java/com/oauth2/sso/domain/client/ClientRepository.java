package com.oauth2.sso.domain.client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Classname ClientRepository
 * @Description
 * @Date 2019/7/15 16:31
 * @Created by ZLW
 * @Author zlw
 */
@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

  Client findFirstByClientId(String clientId);
}
