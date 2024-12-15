package com.example.SportsBookingSystem.Entity

import jakarta.persistence.*

@Entity
        class TeamEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long?,
        var name: String,
        var description: String,
        var status: String,
        var homeground: Long) {
}