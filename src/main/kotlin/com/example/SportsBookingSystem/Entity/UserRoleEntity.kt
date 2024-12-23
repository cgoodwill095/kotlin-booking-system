package com.example.SportsBookingSystem.Entity

import jakarta.persistence.*

@Entity
open class UserRoleEntity(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long?,
        @OneToOne
        @JoinColumn(name= "userId", referencedColumnName = "id")
        var user : UserEntity,
        var userRole: String,


)
{

}