package com.hbrooks.security;

import jakarta.annotation.Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    @Resource
    private UserDetailsService userService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userService);
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception{


        //improve this config later to allow adminds to access all and users to only access their journey data

        http.authorizeHttpRequests( configurer ->
                configurer
                        .requestMatchers(HttpMethod.GET, "/journey/journeys/**").hasAnyRole("USER","ADMIN")
                        .requestMatchers(HttpMethod.POST, "/journey/journeys").hasAnyRole("USER","ADMIN")
                        .requestMatchers(HttpMethod.DELETE, "/journey/journeys/**").hasAnyRole("USER", "ADMIN")
        );

        http.httpBasic(Customizer.withDefaults());

        http.csrf(csrf -> csrf.disable());

        return http.build();
    }
}
