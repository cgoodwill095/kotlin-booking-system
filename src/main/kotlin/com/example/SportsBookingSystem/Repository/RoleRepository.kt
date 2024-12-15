package com.example.SportsBookingSystem.Repository

import com.example.SportsBookingSystem.Entity.UserRoleEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository


@Repository
interface RoleRepository : JpaRepository<UserRoleEntity, Long> {
    fun getByUserId(userid : Long) : List<UserRoleEntity>?

}