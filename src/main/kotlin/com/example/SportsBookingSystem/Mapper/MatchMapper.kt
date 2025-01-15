package com.example.SportsBookingSystem.Mapper

import com.example.SportsBookingSystem.DTO.Match.MatchGetDTO
import com.example.SportsBookingSystem.Entity.MatchEntity
import com.example.SportsBookingSystem.Entity.PlayerMatchLinkEntity
import com.example.SportsBookingSystem.Entity.TeamMatchLinkEntity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import org.springframework.stereotype.Component

@Component
class MatchMapper {

    fun mapEntityToBasicGetDTO(matchEntity: MatchEntity) : MatchGetDTO
    {
        val matchGetDTO = MatchGetDTO()
        matchGetDTO.id = matchEntity.id
        matchGetDTO.location_id = matchEntity.location_id
        matchGetDTO.status = matchEntity.status
        matchGetDTO.description = matchEntity.description
        matchGetDTO.playerMatchLinks = matchEntity.playerMatchLinks
        matchGetDTO.teamMatchLinks = matchEntity.teamMatchLinks
        return matchGetDTO
    }


//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    var id: Long?,
//    var location_id: Long,
//    var description: String,
//    var status: String,
//    @OneToMany(mappedBy = "match" , targetEntity = PlayerMatchLinkEntity::class)
//    var playerMatchLinks: Set<PlayerMatchLinkEntity>,
//    @OneToMany(mappedBy = "match" , targetEntity = TeamMatchLinkEntity::class)
//    var teamMatchLinks: Set<TeamMatchLinkEntity>

/*
    fun mapEntityToGetDto(playerEntity: PlayerEntity): PlayerGetDTO{

    }

    fun mapPutDtoToEntity(dto: PlayerPutDTO, playerEntity: PlayerEntity) : PlayerEntity{

    }

    fun mapCreateDtoToEntity(dto: PlayerCreateDTO) : PlayerEntity{

    }*/
}