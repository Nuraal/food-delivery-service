package com.example.fooddeliveryservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                // REST API үшін CSRF-ті өшіру міндетті, әйтпесе POST өтпейді
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                        // 1. Барлық API-ге уақытша толық рұқсат беру (тексеру үшін)
                        // Егер 401 қатесі кетсін десең, мына жолды қолдан:
                        .requestMatchers("/api/**").permitAll()

                        /* ТЕКСЕРІП БОЛҒАН СОҢ МЫНА ЖЕРДІ ҚАЙТА ҚОСАСЫҢ:
                        .requestMatchers("/api/users/register").permitAll()
                        .requestMatchers(HttpMethod.GET, "/api/restaurants/**", "/api/dishes/**").permitAll()
                        .requestMatchers(HttpMethod.POST, "/api/restaurants/**").hasRole("ADMIN")
                        .anyRequest().authenticated()
                        */

                        .anyRequest().permitAll()
                )
                // Postman-мен жұмыс істеу үшін Basic Auth қосулы тұрсын
                .httpBasic(Customizer.withDefaults());

        return http.build();
    }
}