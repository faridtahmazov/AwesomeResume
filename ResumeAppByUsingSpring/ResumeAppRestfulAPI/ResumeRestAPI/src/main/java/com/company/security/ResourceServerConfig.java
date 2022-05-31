package com.company.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter { //Serverin ayaga qalxmagi buradan bashlayir
    @Autowired
    private ResourceServerTokenServices resourceServerTokenServices;

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        /**
         * filan resurs, filan tokenservicle idare olunur
         * bura oauth2 emeliyyatlarinin cemleshdiyi noqtedir
         *
         */
        resources
                .resourceId("restapi")
                .tokenServices(resourceServerTokenServices);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .requestMatchers()
                .and()
                .authorizeRequests().antMatchers("/users").hasAnyAuthority("ADMIN")
                .and()
                .authorizeRequests().antMatchers("/foo").hasAnyAuthority("ADMIN", "USER")
                .antMatchers("/login/**", "/logout/**").permitAll()
                .antMatchers("/**" ).authenticated();
    }
}
