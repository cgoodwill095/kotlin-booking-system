package com.example.SportsBookingSystem

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.annotation.Order
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.invoke
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.provisioning.InMemoryUserDetailsManager
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity
class SecurityConfig {

}

@Order(1) //@Order(1) lets the compiler know that this needs to be run before any other classes in this file
@Configuration
class AdminSecurityConfiguration {
    @Bean
    fun filterChainAdmin(http: HttpSecurity): SecurityFilterChain {
        http.invoke {
            securityMatcher("/admin/**")
            authorizeHttpRequests {
                authorize("/admin/**", hasAuthority("ROLE_ADMIN"))
            }
            httpBasic {}
        }
        return http.build()
    }

}

@Configuration
class BasicSecurityConfiguration {
    @Bean
    fun filterChainBasic(http: HttpSecurity): SecurityFilterChain {
        http {
            authorizeHttpRequests {
                authorize("/**", permitAll)
            }
            httpBasic {}
        }
        return http.build()
    }
}

