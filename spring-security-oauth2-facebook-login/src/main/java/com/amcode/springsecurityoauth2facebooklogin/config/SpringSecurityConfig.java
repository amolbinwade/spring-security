package com.amcode.springsecurityoauth2facebooklogin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Configuration class for Spring security
 * @author : Amol Binwade
 */
@Configuration
public class SpringSecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

        /* old way without lambda
        http.authorizeRequests().anyRequest().authenticated().and().oauth2Login(Customizer.withDefaults());
        return http.build();
        */

        //Spring will read configs related to oauth2 client registration and auto-configure components needed for
        //facebook based oauth2 logic
        http.authorizeHttpRequests(
                authorize -> authorize.anyRequest().authenticated()
        ). oauth2Login(Customizer.withDefaults());

        return http.build();
    }
}
