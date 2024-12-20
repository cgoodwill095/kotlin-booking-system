package com.example.SportsBookingSystem.Rest.Controller

import com.example.SportsBookingSystem.Entity.PlayerEntity
import com.example.SportsBookingSystem.Entity.TeamEntity
import com.example.SportsBookingSystem.Service.PlayerService
import com.example.SportsBookingSystem.Service.TeamService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/team")
class TeamRestController(private val teamService: TeamService) {
/*
    @GetMapping("/findAll")
    fun findAll(): List<TeamEntity>
    {
        if(teamService.findAll().isEmpty())
        {
            throw NoSuchElementException("There are no teams registered")
        }
        return teamService.findAll()
    }

    @GetMapping("/player/findAll/{teamId}")
    fun findAllPlayersByTeam(): List<TeamEntity>
    {
        if(playerService.findAll().isEmpty())
        {
            throw NoSuchElementException("There are no teams registered")
        }
        return playerService.findAll()
    }

    @GetMapping("/findByStatus/{status}")
    fun findTeamsByStatus(): List<TeamEntity>
    {
        if(teamService.findAll().isEmpty())
        {
            throw NoSuchElementException("There are no teams registered")
        }
        return teamService.findAll()
    }


    @PutMapping("/")
    fun putTeam(): Boolean
    {
        return true
    }

    @PostMapping("/")
    fun postTeam(): Boolean
    {
        return true
    }
*/

}