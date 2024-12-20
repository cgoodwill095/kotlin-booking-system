package com.example.SportsBookingSystem.Entity

import jakarta.persistence.*

@Entity
open class TeamEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long?,
        var name: String,
        var description: String,
        var active: Boolean,
        var home_ground: Long,
        @OneToMany(mappedBy = "team" , targetEntity = PlayerTeamLinkEntity::class)
        var playerTeamLinks: Set<PlayerTeamLinkEntity>) {
}