package com.example.SportsBookingSystem.Mapper

import com.example.SportsBookingSystem.DTO.Match.MatchGetDTO
import com.example.SportsBookingSystem.Entity.MatchEntity
import org.springframework.stereotype.Component

@Component
class MatchMapper {

    fun mapEntityToBasicGetDTO(matchEntity: MatchEntity) : MatchGetDTO
    {
        val matchGetDTO = MatchGetDTO()
        matchGetDTO.id = matchEntity.id
        matchGetDTO.location_id = matchEntity.location_id
        matchGetDTO.description = matchEntity.description
        matchGetDTO.status = matchEntity.status

        return matchGetDTO
    }


/*
    fun mapEntityToGetDto(playerEntity: PlayerEntity): PlayerGetDTO{

    }

    fun mapPutDtoToEntity(dto: PlayerPutDTO, playerEntity: PlayerEntity) : PlayerEntity{

    }

    fun mapCreateDtoToEntity(dto: PlayerCreateDTO) : PlayerEntity{

    }*/
}