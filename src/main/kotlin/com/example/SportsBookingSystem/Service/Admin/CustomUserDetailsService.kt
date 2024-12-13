package com.example.SportsBookingSystem.Service.Admin

import com.example.SportsBookingSystem.Entity.RoleEntity
import com.example.SportsBookingSystem.Repository.UserRepository
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class CustomUserDetailsService(private val userRepository: UserRepository, private val userService: UserService) : UserDetailsService {
    override fun loadUserByUsername(username: String): UserDetails {

        val user = userRepository.findByUsername(username)
                    ?: throw UsernameNotFoundException("User not found with email: $username")
            return User(
                    user.username,
                    user.password,
                    getAuthorities()
            )
    }

    //private fun getAuthorities(role: RoleEntity): MutableList<GrantedAuthority> {

    private fun getAuthorities(): MutableList<GrantedAuthority> {

        val authorities = mutableListOf<GrantedAuthority>()
        authorities.add(SimpleGrantedAuthority("ROLE_ADMIN"))
        authorities.add(SimpleGrantedAuthority("ROLE_USER"))
/*
        role.permissions.forEach {
            logger.info("Role with name: {}", it.name)
            authorities.add(SimpleGrantedAuthority(it.name))
        }
*/
        return authorities
    }
}

