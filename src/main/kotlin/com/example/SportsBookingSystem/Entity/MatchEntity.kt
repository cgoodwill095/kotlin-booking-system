package com.example.SportsBookingSystem.Entity

import jakarta.persistence.*

@Entity
open class MatchEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long?,
        var location_id: Long,
        var description: String,
        var status: String,
        @OneToMany(mappedBy = "match" , targetEntity = PlayerMatchLinkEntity::class)
        var playerMatchLinks: Set<PlayerMatchLinkEntity>,
        @OneToMany(mappedBy = "match" , targetEntity = TeamMatchLinkEntity::class)
        var teamMatchLinks: Set<TeamMatchLinkEntity>
) {

}