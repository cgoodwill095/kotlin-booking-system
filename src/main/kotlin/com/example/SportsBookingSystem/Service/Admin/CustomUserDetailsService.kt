package com.example.SportsBookingSystem.Service.Admin

import com.example.SportsBookingSystem.Entity.UserEntity
import com.example.SportsBookingSystem.Entity.UserRoleEntity
import com.example.SportsBookingSystem.Repository.RoleRepository
import com.example.SportsBookingSystem.Repository.UserRepository
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class CustomUserDetailsService(private val userRepository: UserRepository, private val roleRepository: RoleRepository) : UserDetailsService {
    override fun loadUserByUsername(username: String): UserDetails {

        val user = userRepository.findByUsername(username)
                    ?: throw UsernameNotFoundException("User not found with email: $username")
            return User(
                    user.username,
                    user.password,
                    getAuthorities(user)
            )
    }

    //private fun getAuthorities(role: RoleEntity): MutableList<GrantedAuthority> {

    private fun getAuthorities(user: UserEntity): MutableList<GrantedAuthority> {

        val authorities = mutableListOf<GrantedAuthority>()
        val roles = ArrayList<UserRoleEntity>()
        user.id?.let { roleRepository.getByUserId(it)?.let { roles.addAll(it) } }
        for (role in roles){
            authorities.add(SimpleGrantedAuthority(role.userRole))
        }
        return authorities
    }
}

