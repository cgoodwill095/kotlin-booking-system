package com.example.SportsBookingSystem.Mapper

import com.example.SportsBookingSystem.DTO.Advert.AdvertBasicDTO
import com.example.SportsBookingSystem.Entity.AdvertEntity
import org.springframework.stereotype.Component

@Component
class AdvertMapper
{
    fun mapAdvertEntityToAdvertBasicDTO(advertEntity: AdvertEntity): AdvertBasicDTO
    {
        val advertGetDTO = AdvertBasicDTO()
        advertGetDTO.id = advertEntity.id
        advertGetDTO.adTyoe = advertEntity.adtype
        advertGetDTO.status = advertEntity.status
        advertGetDTO.hyperlink = advertEntity.hyperlink

        if(advertEntity.matchId != null)
        {
            advertGetDTO.matchId = advertEntity.matchId!!
        }
        if (advertEntity.teamId !=null)
        {
            advertGetDTO.teamId = advertEntity.teamId!!
        }
        if (advertEntity.tournamentId != null)
        {
            advertGetDTO.tournamentId = advertEntity.tournamentId!!
        }
        return advertGetDTO
    }
}