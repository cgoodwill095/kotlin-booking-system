package com.example.SportsBookingSystem.DTO.Match


open class MatchGetDTO(
        var id: Long?,
        var location_id: Long?,
        var description: String,
        var status: String
) {
        constructor(): this(0L, 0L, "", "")
}
