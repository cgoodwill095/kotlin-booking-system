package com.example.SportsBookingSystem.Repository;

import com.example.SportsBookingSystem.Entity.AssignmentEntity
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface AssignmentRepository : JpaRepository<AssignmentEntity, Long>
{
    fun findByAssignmentId(id:Long): AssignmentEntity?
    fun existsByAssignmentId(id: Long?): Boolean
}


