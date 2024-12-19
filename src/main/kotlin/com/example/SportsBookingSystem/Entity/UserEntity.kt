package com.example.SportsBookingSystem.Entity

import jakarta.persistence.*

@Entity
@Table(name = "UserEntity")
open class UserEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long?,
        var username: String,
        var password: String
        ) {
}