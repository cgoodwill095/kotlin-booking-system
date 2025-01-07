package com.example.SportsBookingSystem.Entity
import jakarta.persistence.*


@Entity
open class TeamMatchLinkEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long,
        @ManyToOne
        @JoinColumn(name = "team_id")
        var team: TeamEntity,
        @ManyToOne
        @JoinColumn(name = "match_id")
        var match: MatchEntity,
        var status: String) {
}

