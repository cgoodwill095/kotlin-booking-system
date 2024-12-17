package com.example.SportsBookingSystem.Controller
import com.example.SportsBookingSystem.Entity.*
import com.example.SportsBookingSystem.Service.*
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping
class LocationController(private val locationService: LocationService)
{
    @GetMapping("/findAll")
    fun findAllLocation():List<LocationEntity>
    {
        return locationService.findAllLocation()
    }

    @GetMapping("/get{id}")
    fun getLocaitonById(@PathVariable id:Long):ResponseEntity<LocationEntity>
    {
        val getLocation = locationService.getLocationById(id)
        return ResponseEntity.ok(getLocation)
    }

    @GetMapping("/find{id}")
    fun findLocationById(@PathVariable id:Long):ResponseEntity<LocationEntity>
    {
        val findLocation = locationService.findLocationById(id)
        return ResponseEntity.ok(findLocation)
    }

    @PostMapping("/createLocation")
    fun createLocation(@RequestBody location:LocationEntity):ResponseEntity<LocationEntity>
    {
        val createdLocation = locationService.createLocation(location)
        return ResponseEntity.ok(createdLocation)
    }

    @PutMapping("/updateLocation{id}")
    fun updateLocation(@PathVariable id:Long,@RequestBody location: LocationEntity):ResponseEntity<LocationEntity>
    {
        val updatedLocation = locationService.updateLocation(id, location)
        return ResponseEntity.ok(updatedLocation)
    }

    @DeleteMapping("/delete{id}")
    fun deleteLocation(@PathVariable id:Long):ResponseEntity<Void>
    {
        locationService.deleteLocation(id)
        return ResponseEntity.noContent().build()
    }
}
