package com.example.FootballBookingSystem.Repository;

import com.example.FootballBookingSystem.Entity.AssignmentEntity
import com.example.FootballBookingSystem.Entity.PlayerEntity
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface AssignmentRepository : JpaRepository<AssignmentEntity, String>


