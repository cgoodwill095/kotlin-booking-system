package com.example.SportsBookingSystem.Entity
import jakarta.persistence.*


@Entity
open class DropInRequestEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long,
        var name: String,
        var status: String,
        @ManyToOne()
        @JoinColumn(name = "user_id", referencedColumnName = "id")
        var user: UserEntity,
        @ManyToOne()
        @JoinColumn(name = "match_id", referencedColumnName = "id")
        var match: MatchEntity) {
}

