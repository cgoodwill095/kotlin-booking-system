package com.example.SportsBookingSystem.Entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import org.springframework.data.geo.Point

@Entity
open class LocationEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long?,
        var name: String,
        var description: String,
        var active: Boolean,
        var geolocation: Point) {

}