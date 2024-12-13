package com.example.SportsBookingSystem.Entity

import jakarta.persistence.*

@Entity
class PlayerEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long?,
        var name: String,
        var positions: String,
        var active: Boolean) {
}

