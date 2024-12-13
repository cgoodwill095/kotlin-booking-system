package com.example.SportsBookingSystem.Service

import com.example.SportsBookingSystem.Entity.PlayerEntity
import com.example.SportsBookingSystem.Repository.PlayerRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
import java.util.*
import kotlin.NoSuchElementException

@Service
class PlayerService(private val playerRepository: PlayerRepository)
{
    @Transactional
    fun getPLayerByID(Id:Long):PlayerEntity?
    {
        return playerRepository.findByPlayerId(Id)
    }

    @Transactional
    fun createPlayer(player:PlayerEntity):PlayerEntity
    {
        if(playerRepository.existsByPlayerId(player.id))
        {
            throw IllegalArgumentException("This user already exists.")
        }
        return playerRepository.save(player)
    }

    @Transactional
    fun updatePlayer(id: Long, player:PlayerEntity):PlayerEntity
    {
        val existingPlayer = playerRepository.findByPlayerId(id)
        if(existingPlayer != null)
        {
            existingPlayer.name = player.name
            existingPlayer.positions = player.positions
            existingPlayer.active = player.active
            return playerRepository.save(existingPlayer)
        }

        throw IllegalArgumentException("This user does not exist.")

    }
    @Transactional
    fun deletePlayer(id: Long)
    {
        if(playerRepository.existsByPlayerId(id))
        {
            return playerRepository.deleteById(id)
        }
        throw NoSuchElementException("This user does not exist.")
    }

    @Transactional
    fun findPlayerById(id: Long): PlayerEntity? {
        return playerRepository.findById(id)
            .orElseThrow{ NoSuchElementException("There is no player with id $id") }
    }

    @Transactional
    fun findAll(): List<PlayerEntity>
    {
        return playerRepository.findAll()
    }

}