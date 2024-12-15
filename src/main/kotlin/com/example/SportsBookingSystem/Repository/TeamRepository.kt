package com.example.SportsBookingSystem.Repository;

import com.example.SportsBookingSystem.Entity.TeamEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface TeamRepository : JpaRepository<TeamEntity, Long>
{
    fun findTeamById(id:Long):TeamEntity?
    fun existsById(id:Long?):Boolean
}


