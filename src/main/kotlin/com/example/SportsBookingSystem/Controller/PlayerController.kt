package com.example.SportsBookingSystem.Controller

import com.example.SportsBookingSystem.Entity.PlayerEntity
import com.example.SportsBookingSystem.Service.PlayerService
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/player")
class PlayerController(private val playerService: PlayerService) {

    @GetMapping("/findAll")
    fun findAll(): List<PlayerEntity>
    {
        if(playerService.findAll().isEmpty())
        {
            throw NoSuchElementException("There is no players registered")
        }
        return playerService.findAll()
    }

    @GetMapping("/get{id}")
    fun getPlayerById(@PathVariable id: Long): ResponseEntity<PlayerEntity>
    {
        val player = playerService.getPLayerById(id)

        if(player == null)
        {
            return ResponseEntity.notFound().build()
        }
        return ResponseEntity.ok(player)
    }
    @GetMapping("/find{id}")
    fun findPlayerById(@PathVariable id: Long): ResponseEntity<PlayerEntity>
    {
        val player = playerService.findPlayerById(id)
        if(player == null)
        {
            throw NoSuchElementException("That player doesn't exist")
        }
        return ResponseEntity.ok(player)
    }

    @PostMapping("/createPlayer")
    fun createPlayer(@RequestBody player: PlayerEntity): ResponseEntity<PlayerEntity>
    {
        val creation = playerService.createPlayer(player)
        return ResponseEntity.ok(creation)
    }


    @PutMapping("/{id}")
    fun updatePlayer(@PathVariable id: Long, @RequestBody player: PlayerEntity): ResponseEntity<PlayerEntity>
    {
        val updatePlayer = playerService.updatePlayer(id, player)
        return ResponseEntity.ok(updatePlayer)
    }

    @DeleteMapping("/id")
    fun deletePlayer(@PathVariable id: Long): ResponseEntity<Void>
    {
        playerService.deletePlayer(id)
        return ResponseEntity.noContent().build()
    }
}