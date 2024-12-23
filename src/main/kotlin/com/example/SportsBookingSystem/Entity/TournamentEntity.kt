package com.example.SportsBookingSystem.Entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.OneToMany

@Entity
open class TournamentEntity
    (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Long,
    var name: String,
    var description: String,
    var type: String,
    var status: String,
    @ManyToOne
    @JoinColumn(name = "organisation_id")
    var organisation_id: OrganisationEntity,


    )

{
}