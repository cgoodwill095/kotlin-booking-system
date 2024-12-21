package com.example.SportsBookingSystem.Entity
import jakarta.persistence.*


@Entity
open class PlayerMatchLinkEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long,
        @ManyToOne
        @JoinColumn(name = "player_id")
        var player: PlayerEntity,
        @ManyToOne
        @JoinColumn(name = "match_id")
        var match: MatchEntity,
        var status: String) {
}

