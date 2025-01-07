package com.example.SportsBookingSystem.Repository;

import com.example.SportsBookingSystem.Entity.MatchEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface MatchRepository : JpaRepository<MatchEntity, Long>
{
    fun existsById(Id:Long?):Boolean
    fun findAllByStatus(Status:String):List<MatchEntity>
    fun findAllByDescription(Description:String):List<MatchEntity>
//    fun findByLocation_id(Location:Long): Optional<MatchEntity>
}

