package com.example.SportsBookingSystem.Service.Admin

import com.example.SportsBookingSystem.Entity.UserEntity
import com.example.SportsBookingSystem.Repository.UserRepository
import jakarta.persistence.EntityNotFoundException
import jakarta.transaction.Transactional
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserService(
        private val userRepository: UserRepository,
        private val passwordEncoder: PasswordEncoder)
{
    fun getAllUsers(): List<UserEntity>{
        return userRepository.findAll();
    }

    fun getUserById(id: Long): UserEntity{
        return userRepository.getReferenceById(id);
    }

    fun findUserByUsername(username: String): Boolean{
        return userRepository.existsByUsername(username)
    }
    fun getUserByUsername(username: String): UserEntity?{
        return userRepository.findByUsername(username)
    }

    fun createUser(userEntity: UserEntity) {
        passwordEncoder.encode(userEntity.password)
        userRepository.save(userEntity)
    }

    @Transactional
    fun deleteUser(id: Long) {
        val user = userRepository.findById(id)
                .orElseThrow { EntityNotFoundException("User not found with id: $id") }
        userRepository.delete(user)
    }

    fun createAdmin(){
        val user = UserEntity(2L, "admin", "password")
        createUser(user)

    }

}