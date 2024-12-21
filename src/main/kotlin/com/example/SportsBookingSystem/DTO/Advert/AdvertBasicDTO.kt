package com.example.SportsBookingSystem.DTO.Advert

class AdvertBasicDTO
    (
    var id:Long?,
    var matchId:Long?,
    var teamId:Long?,
    var tournamentId:Long?,
    var adTyoe:String,
    var status:String,
    var hyperlink:String,
)
{
        constructor(): this(0L, 0L,0L, 0L,"", "", "")
}