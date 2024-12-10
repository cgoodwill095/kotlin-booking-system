package com.example.FootballBookingSystem.Repository;

import com.example.FootballBookingSystem.Entity.MatchEntity
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface MatchRepository : JpaRepository<MatchEntity, String>


