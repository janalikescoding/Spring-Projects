package com.example.restsoap.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

  /*
   * Allow all request to /students/**
   * @param http
   * @return
   * @throws Exception
   */
  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
    http.authorizeHttpRequests(auth -> auth.requestMatchers("/students/**")
        .permitAll().anyRequest().authenticated());
    http.httpBasic(Customizer.withDefaults());
    http.csrf(csrf -> csrf.disable());
    return http.build();
  }

  /**
   * Sets the default authentication provider to UserDetailsService
   * @param userDetailsService
   * @return
   */

  @Bean
  public AuthenticationManager authenticationManager(UserDetailsService userDetailsService){
    var authenticationProvider = new DaoAuthenticationProvider();
    authenticationProvider.setUserDetailsService(userDetailsService);

    return new ProviderManager(authenticationProvider);
  }

  /**
   * Initialize UserDetailsService Spring bean with some credentials
   * @return
   */
  @Bean
  public UserDetailsService userDetailsService(){
    UserDetails user1 = User.withUsername("user1")
        .password("{noop}secret1") //encrypts the password before passing directly. {noop} sends it to the NoOpPasswordEncoder
        .authorities("read")
        .roles("USER")
        .build();
    UserDetails user2 = User.withUsername("admin1")
        .password("{noop}secret1")
        .authorities("read")
        .roles("ADMIN")
        .build();
    return new InMemoryUserDetailsManager(user1, user2);
  }
}
