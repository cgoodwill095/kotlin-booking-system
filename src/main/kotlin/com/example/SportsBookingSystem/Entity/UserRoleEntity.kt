package com.example.SportsBookingSystem.Entity

import jakarta.persistence.*

@Entity
class UserRoleEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long?,
        var userId: Int,
        var userRole: String
        )
{

}