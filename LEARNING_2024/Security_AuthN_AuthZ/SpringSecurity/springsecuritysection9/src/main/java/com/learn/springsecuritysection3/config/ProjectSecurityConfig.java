package com.learn.springsecuritysection3.config;

import com.learn.springsecuritysection3.filter.AuthoritiesLogAfterFilter;
import com.learn.springsecuritysection3.filter.JWTTokenGenerationFilter;

import com.learn.springsecuritysection3.filter.JWTTokenValidatorFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
public class ProjectSecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.csrf((csrf) -> csrf.disable())
                .sessionManagement(sessionManagement -> sessionManagement.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(new filter.RequestValidationBeforeFilter(), BasicAuthenticationFilter.class)
                .addFilterAfter(new AuthoritiesLogAfterFilter(),BasicAuthenticationFilter.class)
                .addFilterAfter(new JWTTokenGenerationFilter(),BasicAuthenticationFilter.class)
                .addFilterAfter(new JWTTokenValidatorFilter(),BasicAuthenticationFilter.class)
                .authorizeHttpRequests((requests)->requests.
//                        requestMatchers("/myAccount").hasAuthority("VIEWACCOUNT")
//                       .requestMatchers("/myBalance").hasAnyAuthority("VIEWACCOUNT","VIEWBALANCE")
//                       .requestMatchers("/myLoans").hasAuthority("VIEWLOANSDetails")
//                       .requestMatchers("/myCards").hasAuthority("VIEWCARDS")
//                        .requestMatchers("/notices","/contact","/register").permitAll())
                         requestMatchers("/myAccounts").hasRole("USER")
                        .requestMatchers("/myBalances").hasAnyRole("ADMIN","USER")
                        .requestMatchers("/myLoans").hasRole("USER")
                        .requestMatchers("/myCards").hasRole("ADMIN")
                        .requestMatchers("/notices","/contact","/register").permitAll())
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }



    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
