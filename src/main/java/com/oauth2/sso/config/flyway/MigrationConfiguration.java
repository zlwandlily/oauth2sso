package com.oauth2.sso.config.flyway;

import org.flywaydb.core.Flyway;
import org.springframework.boot.autoconfigure.flyway.FlywayMigrationInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

/**
 * @program: sso
 * @description: flyway配置类
 * @author: zlw
 * @date: 2019-06-20 18:54
 **/
@Configuration
public class MigrationConfiguration {

  /**
   * Override default flyway initializer to do nothing
   */
  @Bean
  FlywayMigrationInitializer flywayInitializer(Flyway flyway) {
    return new FlywayMigrationInitializer(flyway, (f) -> {});
  }


  /**
   * Create a second flyway initializer to run after jpa has created the schema
   */
  @Bean
  @DependsOn("entityManagerFactory")
  FlywayMigrationInitializer delayedFlywayInitializer(Flyway flyway) {
    return new FlywayMigrationInitializer(flyway,null );
  }
}
