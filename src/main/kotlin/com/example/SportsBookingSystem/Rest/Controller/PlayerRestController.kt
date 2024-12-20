package com.example.SportsBookingSystem.Rest.Controller

import com.example.SportsBookingSystem.Entity.PlayerEntity
import com.example.SportsBookingSystem.Service.PlayerService
import org.springframework.web.bind.annotation.*
import java.util.Optional

@RestController
@RequestMapping("/api/player")
class PlayerRestController(private val playerService: PlayerService) {

    // http -a user:password get http://localhost:8090/api/player/findById?playerId=3
    @GetMapping("/findById")
    fun findById(@RequestParam playerId: Int): PlayerEntity
    {
        val playerEntity: Optional<PlayerEntity> = playerService.getPLayerById(playerId.toLong())
        if(playerEntity.isPresent){
            return playerEntity.get()
        }
        else{
            throw NoSuchElementException("There are no players registered with that ID")
        }
    }
// http -a user:password get http://localhost:8090/api/player/findall
    @GetMapping("/findAll")
    fun findAll(): List<PlayerEntity>
    {
        if(playerService.findAll().isEmpty())
        {
            throw NoSuchElementException("There are no players registered")
        }
        return playerService.findAll()
    }

    @GetMapping("/team/findAll")
    fun findAllByTeam(@RequestParam teamId: Int): List<PlayerEntity>
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