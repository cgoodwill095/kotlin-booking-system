package com.example.SportsBookingSystem.Mapper

import com.example.SportsBookingSystem.DTO.Player.PlayerBasicGetDTO
import com.example.SportsBookingSystem.DTO.Player.PlayerCreateDTO
import com.example.SportsBookingSystem.DTO.Player.PlayerGetDTO
import com.example.SportsBookingSystem.DTO.Player.PlayerPutDTO
import com.example.SportsBookingSystem.Entity.PlayerEntity
import org.springframework.stereotype.Component

@Component
class PlayerMapper {

    fun mapEntityToBasicGetDTO(playerEntity: PlayerEntity) : PlayerBasicGetDTO{
        val playerGetDTO = PlayerBasicGetDTO()
        playerGetDTO.id = playerEntity.id
        playerGetDTO.name = playerEntity.name
        playerGetDTO.status = playerEntity.status
        if(playerEntity.user.id!=null){
            playerGetDTO.userId = playerEntity.user.id!!
        }
        return playerGetDTO;
    }
/*
    fun mapEntityToGetDto(playerEntity: PlayerEntity): PlayerGetDTO{

    }

    fun mapPutDtoToEntity(dto: PlayerPutDTO, playerEntity: PlayerEntity) : PlayerEntity{

    }

    fun mapCreateDtoToEntity(dto: PlayerCreateDTO) : PlayerEntity{

    }*/
}