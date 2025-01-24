package com.example.SportsBookingSystem.Mapper

import com.example.SportsBookingSystem.DTO.Match.MatchGetDTO
import com.example.SportsBookingSystem.DTO.Match.MatchPutDTO
import com.example.SportsBookingSystem.Entity.MatchEntity

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
    fun mapEntityToPutDTO(matchEntity: MatchEntity) : MatchPutDTO
    {
        val matchPutDTO = MatchPutDTO()
        matchPutDTO.id = matchEntity.id
        matchPutDTO.location_id = matchEntity.location_id
        matchPutDTO.status = matchEntity.status
        matchPutDTO.description = matchEntity.description
        matchPutDTO.playerMatchLinks = matchEntity.playerMatchLinks
        matchPutDTO.teamMatchLinks = matchEntity.teamMatchLinks
        return matchPutDTO
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