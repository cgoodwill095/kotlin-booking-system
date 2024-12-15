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
    fun getPLayerById(id:Long): Optional<PlayerEntity>
    {
        return playerRepository.findById(id)
    }

    @Transactional
    fun createPlayer(player:PlayerEntity):PlayerEntity
    {
        if(playerRepository.existsById(player.id))
        {
            throw IllegalArgumentException("This user already exists.")
        }
        return playerRepository.save(player)
    }

    @Transactional
    fun updatePlayer(id: Long, player:PlayerEntity):PlayerEntity
    {
        val playerEntity: Optional<PlayerEntity> = playerRepository.findById(id)


        if(playerEntity.isPresent)
        {
            playerEntity.get().name = player.name
            playerEntity.get().status = player.status
            return playerRepository.save(playerEntity.get())
        }
        throw IllegalArgumentException("This user does not exist.")

    }
    @Transactional
    fun deletePlayer(id: Long)
    {
        if(playerRepository.existsById(id))
        {
            return playerRepository.deleteById(id)
        }
        throw NoSuchElementException("This user does not exist.")
    }

    @Transactional
    fun findPlayerById(id: Long): PlayerEntity? {
        return playerRepository.findById(id).orElseThrow{ NoSuchElementException("There is no player with id $id") }
    }

    @Transactional
    fun findAll(): List<PlayerEntity>
    {
        return playerRepository.findAll()
    }

    @Transactional
    fun findAllActive(status: String):List<PlayerEntity>
    {
        return playerRepository.findAllByStatus(status)
    }

}