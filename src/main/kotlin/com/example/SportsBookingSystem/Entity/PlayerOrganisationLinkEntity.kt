package com.example.SportsBookingSystem.Entity
import jakarta.persistence.*


@Entity
open class PlayerOrganisationLinkEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long,
        @ManyToOne
        @JoinColumn(name = "player_id")
        var player: PlayerEntity,
        @ManyToOne
        @JoinColumn(name = "organisation_id")
        var organisation: OrganisationEntity,
        var status: String) {
}

