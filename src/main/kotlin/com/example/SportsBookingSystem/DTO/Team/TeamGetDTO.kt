package com.example.SportsBookingSystem.DTO.Team
import com.example.SportsBookingSystem.DTO.Match.MatchBasicDTO
import com.example.SportsBookingSystem.DTO.Team.TeamBasicDTO
import com.example.SportsBookingSystem.Entity.UserEntity


open class TeamGetDTO(
        val id: Long,
        val name: String,
        val status: String,
        val teams: Set<TeamBasicDTO>,
        val matches: Set<MatchBasicDTO>,
        var user: UserEntity) {
}

