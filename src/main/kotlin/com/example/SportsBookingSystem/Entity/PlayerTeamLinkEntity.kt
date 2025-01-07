package com.example.SportsBookingSystem.Entity
import jakarta.persistence.*


@Entity
open class PlayerTeamLinkEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long,
        @ManyToOne
        @JoinColumn(name = "player_id")
        var player: PlayerEntity,
        @ManyToOne
        @JoinColumn(name = "team_id")
        var team: TeamEntity,
        var status: String) {
}

