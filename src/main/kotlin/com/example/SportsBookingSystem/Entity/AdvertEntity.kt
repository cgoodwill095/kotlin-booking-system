package com.example.SportsBookingSystem.Entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
class AdvertEntity (
        var adtype: String,
        var hyperlink: String,
        var matchId: Long?,
        var teamId: Long?,
        var tournamentId: Long?,
        var status: String,
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long?
        )


