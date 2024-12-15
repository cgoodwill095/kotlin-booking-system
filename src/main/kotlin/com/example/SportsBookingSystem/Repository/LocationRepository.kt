package com.example.SportsBookingSystem.Repository;

import com.example.SportsBookingSystem.Entity.LocationEntity
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface LocationRepository : JpaRepository<LocationEntity, Long>
{
    fun findByLocationId(id: Long):LocationEntity?
    fun existsByLocationId(id:Long?):Boolean
}


