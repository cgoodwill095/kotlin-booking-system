package com.example.FootballBookingSystem.Repository;

import com.example.FootballBookingSystem.Entity.PlayerEntity
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface PlayerRepository : JpaRepository<PlayerEntity, String>


