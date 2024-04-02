package com.estsoft.for1person.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.boot.autoconfigure.security.servlet.PathRequest.toH2Console;


@EnableWebSecurity
@Configuration
public class WebSecurityConfig {

    @Bean
    public WebSecurityCustomizer configure() {
        return web -> web.ignoring().requestMatchers(toH2Console())
                .requestMatchers("/static/**")
                .requestMatchers("/css/**")
                .requestMatchers("/js/**")
                .requestMatchers("/Img/**");
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(auth ->              // 인증, 인가 설정
                        auth.requestMatchers("/login", "/membership", "/user","/admin", "/checkUsername", "/checkNickname", "/updateInfo", "/updateAuthor", "/userList").permitAll()
                                .anyRequest().authenticated())
                .formLogin(auth -> auth.loginPage("/login")
                        .defaultSuccessUrl("/main"))
                .logout(auth -> auth.logoutSuccessUrl("/login")
                        .invalidateHttpSession(true))
                .csrf(auth -> auth.disable());
        return httpSecurity.build();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
