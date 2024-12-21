package com.example.SportsBookingSystem.Entity
import jakarta.persistence.*


@Entity
open class OrganisationEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long,
        var name: String,
        var status: String,
        @OneToMany(mappedBy = "organisation" , targetEntity = PlayerOrganisationLinkEntity::class)
        var playerOrganisationLinks: Set<PlayerOrganisationLinkEntity>,
) {
}

