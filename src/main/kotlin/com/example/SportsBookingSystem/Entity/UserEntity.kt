package com.example.SportsBookingSystem.Entity

import jakarta.persistence.*

@Entity
@Table(name = "Random_users")
class UserEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long,
        var first_name: String,
        var last_name: String,
        var description: String,
        var phone_number: String,
        var email: String,)
{
}
