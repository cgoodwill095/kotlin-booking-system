package com.example.FootballBookingSystem.Repository;

import com.example.FootballBookingSystem.Entity.LocationEntity
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface LocationRepository : JpaRepository<LocationEntity, String>


