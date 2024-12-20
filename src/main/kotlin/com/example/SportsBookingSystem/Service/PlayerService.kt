package com.example.SportsBookingSystem.Service
import com.example.SportsBookingSystem.DTO.Player.PlayerBasicGetDTO
import com.example.SportsBookingSystem.Entity.PlayerEntity
import com.example.SportsBookingSystem.Mapper.PlayerMapper
import com.example.SportsBookingSystem.Repository.PlayerRepository
import com.example.SportsBookingSystem.Repository.PlayerTeamLinkRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
import java.util.*
import kotlin.NoSuchElementException
@Service
class PlayerService(private val playerRepository: PlayerRepository,
        private val playerMapper: PlayerMapper,
        private val playerTeamLinkRepository: PlayerTeamLinkRepository)
{
    @Transactional
    fun getPlayerById(id:Long): Optional<PlayerEntity>
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
    fun findAllBasicDTO(): List<PlayerBasicGetDTO>
    {
        val players : List<PlayerEntity> = playerRepository.findAll()
        val playersDTO = mutableListOf(PlayerBasicGetDTO())
        playersDTO.removeAt(0)
        for(player in players){
            playersDTO.add(playerMapper.mapEntityToBasicGetDTO(player))
        }
        return playersDTO
    }

    @Transactional
    fun findAllByTeam(teamId: Long): List<PlayerBasicGetDTO>
    {
        val playersDTO = mutableListOf(PlayerBasicGetDTO())
        playersDTO.removeAt(0)
        for(link in playerTeamLinkRepository.getByTeamId(teamId)){
            playersDTO.add(playerMapper.mapEntityToBasicGetDTO(link.player))
        }
        return playersDTO
    }

    @Transactional
    fun findAllByStatus(status: String): List<PlayerBasicGetDTO>
    {
        val playersDTO = mutableListOf(PlayerBasicGetDTO())
        playersDTO.removeAt(0)
        for(player in playerRepository.findAllByStatus(status)){
            playersDTO.add(playerMapper.mapEntityToBasicGetDTO(player))
        }
        return playersDTO
    }
    @Transactional
    fun findAllActive(status: String):List<PlayerEntity>
    {
        return playerRepository.findAllByStatus(status)
    }

    fun mapEntityToBasicDTO(playerEntity: PlayerEntity):PlayerBasicGetDTO{
        return playerMapper.mapEntityToBasicGetDTO(playerEntity)
    }

}