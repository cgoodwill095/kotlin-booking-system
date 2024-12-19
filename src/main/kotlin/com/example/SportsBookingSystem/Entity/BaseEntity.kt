package com.example.SportsBookingSystem.Entity

import jakarta.persistence.*
import lombok.AllArgsConstructor
import lombok.NoArgsConstructor
import java.time.LocalDateTime

@MappedSuperclass
abstract class BaseEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long,
        var createdAt: LocalDateTime,
        var updatedAt: LocalDateTime
        ) {
}