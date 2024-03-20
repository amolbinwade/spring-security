package com.amcode.springsecurityoauth2facebooklogin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

        /*http.authorizeRequests().anyRequest().authenticated().and().oauth2Login(Customizer.withDefaults());
        return http.build();*/

        http.authorizeHttpRequests(
                authorize -> authorize.anyRequest().authenticated()
        ). oauth2Login(Customizer.withDefaults());

        return http.build();
    }
}
