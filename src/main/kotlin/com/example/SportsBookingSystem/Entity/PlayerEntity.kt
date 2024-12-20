package com.example.SportsBookingSystem.Entity
import jakarta.persistence.*


@Entity
open class PlayerEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long,
        var name: String,
        var status: String,
        @OneToOne()
        @JoinColumn(name = "user_id", referencedColumnName = "id")
        var user: UserEntity) {
}

