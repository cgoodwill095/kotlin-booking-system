package com.example.SportsBookingSystem.Entity

import jakarta.persistence.*
import lombok.Getter
import lombok.Setter

@Entity
@Getter
@Setter
@Table(name = "UserRoleEntity")
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