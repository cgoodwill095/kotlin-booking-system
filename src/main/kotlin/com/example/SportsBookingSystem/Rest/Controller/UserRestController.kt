package com.example.SportsBookingSystem.Rest.Controller

import com.example.SportsBookingSystem.Entity.PlayerEntity
import com.example.SportsBookingSystem.Service.PlayerService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/user")
class UserRestController(private val playerService: PlayerService) {

    @GetMapping("/findAll")
    fun findAll(): List<PlayerEntity>
    {
        if(playerService.findAll().isEmpty())
        {
            throw NoSuchElementException("There is no players registered")
        }
        return playerService.findAll()
    }

    @GetMapping("/team/findAll/{teamId}")
    fun findAllByTeam(): List<PlayerEntity>
    {
        if(playerService.findAll().isEmpty())
        {
            throw NoSuchElementException("There is no players registered")
        }
        return playerService.findAll()
    }

    @GetMapping("/findByStatus/{status}")
    fun findByStatus(): List<PlayerEntity>
    {
        if(playerService.findAll().isEmpty())
        {
            throw NoSuchElementException("There is no players registered")
        }
        return playerService.findAll()
    }


    @PutMapping("/")
    fun putPlayer(): Boolean
    {
        if(playerService.findAll().isEmpty())
        {
            throw NoSuchElementException("There is no players registered")
        }
        return true
    }

    @PostMapping("/")
    fun postPlayer(): PlayerEntity
    {
        val playerEntity: PlayerEntity
        playerEntity= playerService.findPlayerById(1)!!
        if(playerService.findAll().isEmpty())
        {
            throw NoSuchElementException("There is no players registered")
        }
        return playerEntity
    }

    @PostMapping("/team/{playerId}{teamId}")
    fun createPlayerTeamLink(): Boolean{
        return false
    }
    @PutMapping("/team/{playerId}{teamId}")
    fun updatePlayerTeamLink(): Boolean{
        return false
    }
    @DeleteMapping("/team/{playerId}{teamId}")
    fun deletePlayerTeamLink(): Boolean{
        return false
    }


}