package org.example.spring.boot.ldap1.configuration;

import org.camunda.bpm.engine.impl.plugin.AdministratorAuthorizationPlugin;
import org.camunda.bpm.identity.impl.ldap.plugin.LdapIdentityProviderPlugin;
import org.camunda.bpm.spring.boot.starter.configuration.Ordering;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Configuration
public class LdapConfigurator {

    @Bean
    @Order(Ordering.DEFAULT_ORDER - 1)
    @ConfigurationProperties(prefix="security.ldap")
    public LdapIdentityProviderPlugin ldapIdentityProviderPlugin(){
        return new LdapIdentityProviderPlugin();
    }

    @Bean
    @Order(Ordering.DEFAULT_ORDER - 1)
    @ConfigurationProperties(prefix="security.administrator")
    public AdministratorAuthorizationPlugin administratorAuthorizationPlugin(){
        return new AdministratorAuthorizationPlugin();
    }
}
