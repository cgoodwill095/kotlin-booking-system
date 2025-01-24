package com.example.SportsBookingSystem.DTO.Match

import com.example.SportsBookingSystem.Entity.PlayerMatchLinkEntity
import com.example.SportsBookingSystem.Entity.TeamMatchLinkEntity

open class MatchPutDTO(
    var id: Long?,
    var location_id: Long?,
    var description: String,
    var status: String,
    var playerMatchLinks: Set<PlayerMatchLinkEntity>,
    var teamMatchLinks: Set<TeamMatchLinkEntity>
){
    constructor(): this(0L, 0L, "", "",emptySet(),emptySet())
}