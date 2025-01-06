package com.example.SportsBookingSystem.Entity
import jakarta.persistence.*
import org.w3c.dom.stylesheets.LinkStyle


@Entity
open class PlayerEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long,
        var name: String,
        var status: String,
        @OneToMany(mappedBy = "player" , targetEntity = PlayerMatchLinkEntity::class)
        var playerMatchLinks: Set<PlayerMatchLinkEntity>,
        @OneToMany(mappedBy = "player" , targetEntity = PlayerOrganisationLinkEntity::class)
        var playerOrganisationLinks: Set<PlayerOrganisationLinkEntity>,
        @OneToMany(mappedBy = "player" , targetEntity = PlayerTeamLinkEntity::class)
        var playerTeamLinks: Set<PlayerTeamLinkEntity>,
        @OneToOne()
        @JoinColumn(name = "user_id", referencedColumnName = "id")
        var user: UserEntity) {
}

