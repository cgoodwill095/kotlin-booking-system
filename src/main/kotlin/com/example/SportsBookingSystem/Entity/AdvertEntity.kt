package com.example.SportsBookingSystem.Entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import lombok.NoArgsConstructor


@Entity
open class AdvertEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long?,
        var adtype: String,
        var hyperlink: String,
        var matchId: Long?,
        var teamId: Long?,
        var tournamentId: Long?,
        var status: String
        )


