package com.example.SportsBookingSystem.Service
import com.example.SportsBookingSystem.Entity.LocationEntity
import com.example.SportsBookingSystem.Repository.LocationRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
import kotlin.NoSuchElementException

@Service
class LocationService(private val locationRepository: LocationRepository)
{
    @Transactional
    fun getLocationById(id:Long):LocationEntity?
    {
        if(locationRepository.existsById(id))
        {
            return locationRepository.getReferenceById(id);
        }
        throw NoSuchElementException("Location doesn't exist")
    }

    @Transactional
    fun createLocation(location: LocationEntity):LocationEntity
    {
        if(locationRepository.existsById(location.id))
        {
            throw IllegalArgumentException("This location already exists")
        }
        return locationRepository.save(location)
    }

    @Transactional
    fun updateLocation(id:Long, location:LocationEntity):LocationEntity
    {
        val locationExisits = locationRepository.getReferenceById(id)
        if(locationExisits != null)
        {
            locationExisits.name = location.name
            locationExisits.description = location.description
            locationExisits.active = location.active
            locationExisits.geolocation = location.geolocation
            locationRepository.save(locationExisits)
        }
        throw NoSuchElementException("The location you are updating does not exist")
    }

    @Transactional
    fun deleteLocation(id:Long)
    {
        if(locationRepository.existsById(id))
        {
            return locationRepository.deleteById(id)
        }
        throw NoSuchElementException("There is no Location that matches this ID")
    }

    @Transactional
    fun findLocationById(id:Long):LocationEntity?
    {
        return locationRepository.findById(id)
            .orElseThrow{ NoSuchElementException("There is no player with id $id") }
    }

    @Transactional
    fun findAllLocation():List<LocationEntity>
    {
        return locationRepository.findAll()
    }
}



