package com.example.SportsBookingSystem.DTO.Match

import com.example.SportsBookingSystem.Entity.PlayerMatchLinkEntity
import com.example.SportsBookingSystem.Entity.TeamMatchLinkEntity


open class MatchGetDTO(
        var id: Long?,
        var location_id: Long?,
        var description: String,
        var status: String,
        var playerMatchLinks: Set<PlayerMatchLinkEntity>,
        var teamMatchLinks: Set<TeamMatchLinkEntity>
) {
        constructor(): this(0L, 0L, "", "",emptySet(),emptySet())
}

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    var id: Long?,
//    var location_id: Long,
//    var description: String,
//    var status: String,
//    @OneToMany(mappedBy = "match" , targetEntity = PlayerMatchLinkEntity::class)
//    var playerMatchLinks: Set<PlayerMatchLinkEntity>,
//    @OneToMany(mappedBy = "match" , targetEntity = TeamMatchLinkEntity::class)
//    var teamMatchLinks: Set<TeamMatchLinkEntity>