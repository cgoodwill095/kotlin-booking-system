package com.example.SportsBookingSystem.Repository;

import com.example.SportsBookingSystem.Entity.PlayerTeamLinkEntity
import com.example.SportsBookingSystem.Entity.TeamEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface PlayerTeamLinkRepository : JpaRepository<PlayerTeamLinkEntity, Long>
{
    fun existsById(id:Long?):Boolean

    fun getByTeamId(id:Long):List<PlayerTeamLinkEntity>
}


