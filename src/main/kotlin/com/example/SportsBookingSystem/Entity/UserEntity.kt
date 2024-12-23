package com.example.SportsBookingSystem.Entity

import jakarta.persistence.*
import lombok.Getter
import lombok.Setter

@Entity
@Getter
@Setter
@Table(name = "UserEntity")
open class UserEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long?,
        var username: String,
        var password: String,

        @OneToOne(mappedBy = "user", targetEntity = UserRoleEntity::class)
        var userEntityToUserRoleLink: UserRoleEntity,
        @OneToOne(mappedBy = "user", targetEntity = PlayerEntity::class)
        var userEntityToPlayerEntity: PlayerEntity,)
{
}