package com.example.SportsBookingSystem.Repository;

import com.example.SportsBookingSystem.Entity.MatchEntity
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface MatchRepository : JpaRepository<MatchEntity, Long>
{
    fun existsById(Id:Long?):Boolean
}

