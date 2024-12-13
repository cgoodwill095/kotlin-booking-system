package com.example.SportsBookingSystem.Entity

import jakarta.persistence.*

@Entity
class RoleEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long?,
        var name: String)
{

}