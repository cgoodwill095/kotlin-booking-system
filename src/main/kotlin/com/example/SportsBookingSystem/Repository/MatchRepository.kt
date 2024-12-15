package com.example.SportsBookingSystem.Repository;

import com.example.SportsBookingSystem.Entity.MatchEntity
import com.example.SportsBookingSystem.Entity.PlayerEntity
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface MatchRepository : JpaRepository<MatchEntity, Long>
{
    fun findByMatchId(Id:Long): MatchEntity?
    fun existsByMatchId(Id:Long?):Boolean
}

