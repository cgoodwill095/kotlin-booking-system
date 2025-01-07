package com.example.SportsBookingSystem.DTO.Player
import com.example.SportsBookingSystem.Entity.PlayerMatchLinkEntity
import com.example.SportsBookingSystem.Entity.UserEntity
import jakarta.persistence.*
import lombok.NoArgsConstructor
import org.w3c.dom.stylesheets.LinkStyle

data class PlayerBasicGetDTO(
        var id: Long,
        var name: String,
        var status: String,
        var userId: Long)
{
    constructor() : this(0L, "", "", 0L )
}

