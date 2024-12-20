package com.example.SportsBookingSystem.DTO.Match
import com.example.SportsBookingSystem.DTO.Match.MatchBasicDTO
import com.example.SportsBookingSystem.DTO.Team.TeamBasicDTO
import com.example.SportsBookingSystem.Entity.UserEntity


open class MatchGetDTO(
        val id: Long,
        val name: String,
        val status: String,
        val teams: Set<TeamBasicDTO>,
        val matches: Set<MatchBasicDTO>,
        var user: UserEntity) {
}

