package com.example.SportsBookingSystem.Entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
open class MatchEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long?,
        var tournamentId: Long,
        var locationId: Long,
        var homeTeamId: Long,
        var awayTeamId: Long,
        var description: String,
        var status: String,
        var homeScore: Int,
        var awayScore: Int) {

}