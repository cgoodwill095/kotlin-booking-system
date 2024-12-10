package com.example.FootballBookingSystem.Repository;

import com.example.FootballBookingSystem.Entity.TeamEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface TeamRepository : JpaRepository<TeamEntity, String>


