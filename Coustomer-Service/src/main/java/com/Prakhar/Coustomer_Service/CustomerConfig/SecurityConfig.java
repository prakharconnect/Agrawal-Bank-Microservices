package com.Prakhar.Coustomer_Service.CustomerConfig;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

     @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{



                http.csrf(csrf->csrf.disable());

               http.authorizeHttpRequests(auth -> auth
                // 1. Customer Banana (Sign Up) sabke liye khula hai (Public)
                               .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                .requestMatchers(HttpMethod.POST, "/api/v1/customers").permitAll()
                       .anyRequest().authenticated()

               )
                        // Hum Oauth2 tokens use krege yha pr
                       .oauth2ResourceServer(oauth2->oauth2.jwt(jwt->{}));
        return http.build();
    }


}
