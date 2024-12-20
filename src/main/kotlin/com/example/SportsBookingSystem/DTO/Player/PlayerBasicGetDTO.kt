package com.example.SportsBookingSystem.DTO.Player
import com.example.SportsBookingSystem.Entity.PlayerMatchLinkEntity
import com.example.SportsBookingSystem.Entity.UserEntity
import jakarta.persistence.*
import org.w3c.dom.stylesheets.LinkStyle


open class PlayerBasicGetDTO(
        var id: Long,
        var name: String,
        var status: String,
        var user: UserEntity) {
}

