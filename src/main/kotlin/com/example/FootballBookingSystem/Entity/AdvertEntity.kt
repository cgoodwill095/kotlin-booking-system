package com.example.FootballBookingSystem.Entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import org.springframework.data.annotation.Id

@Entity
class AdvertEntity (
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

{

}

