package com.example.FootballBookingSystem.Repository;

import com.example.FootballBookingSystem.Entity.AdvertEntity
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface AdvertRepository : JpaRepository<AdvertEntity, String>


