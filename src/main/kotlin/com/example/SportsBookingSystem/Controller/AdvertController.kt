package com.example.SportsBookingSystem.Controller
import com.example.SportsBookingSystem.Entity.AdvertEntity
import com.example.SportsBookingSystem.Service.AdvertService
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping
class AdvertController(private val advertService: AdvertService)
{
    @GetMapping("/findAll")
    fun findAllAdverts():List<AdvertEntity>
    {
        return advertService.findAllAdverts()

    }
    @GetMapping("/get{id}")
    fun getAdvertById(@PathVariable id:Long):ResponseEntity<AdvertEntity>
    {
        val getAdvert = advertService.getAdvertById(id)
        return ResponseEntity.ok(getAdvert)
    }
    @GetMapping("/find{id}")
    fun findAdvertById(@PathVariable id:Long):ResponseEntity<AdvertEntity>
    {
        val found = advertService.findAdvertById(id)
        return ResponseEntity.ok(found)
    }

    @PostMapping("/createAdvert")
    fun createAdvert(@RequestBody advery: AdvertEntity): ResponseEntity<AdvertEntity>
    {
        val advert = advertService.createAdvert(advery)
        return ResponseEntity.ok(advert)
    }
    @PutMapping("/updateAdvert{id}")
    fun updateAdvert(@PathVariable id:Long, @RequestBody advert:AdvertEntity):ResponseEntity<AdvertEntity>
    {
        val updatedAdvert = advertService.updateAdvert(id, advert)
        return ResponseEntity.ok(updatedAdvert)
    }

    @DeleteMapping("/delete{id}")
    fun deleteAdvert(@PathVariable id:Long):ResponseEntity<Void>
    {
        advertService.deleteAdvert(id)
        return ResponseEntity.noContent().build()
    }
}
