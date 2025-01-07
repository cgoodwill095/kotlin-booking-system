package com.example.SportsBookingSystem.Rest.Controller

import com.example.SportsBookingSystem.DTO.Advert.AdvertBasicDTO
import com.example.SportsBookingSystem.Entity.AdvertEntity
import com.example.SportsBookingSystem.Mapper.AdvertMapper
import com.example.SportsBookingSystem.Service.AdvertService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.Optional

@RestController
@RequestMapping("/api/advert")
class AdvertRestController(private val advertService: AdvertService,
                           private val advertMapper: AdvertMapper) {

    @GetMapping("/findByid")
    fun findById(@RequestParam advertId: Long): AdvertBasicDTO {
        val advertEntity: Optional<AdvertEntity> = advertService.getAdvertById(advertId)
        if (advertEntity.isPresent) {
            return advertService.mapEntityToBasicDTO(advertEntity.get())
        }
        throw NoSuchElementException("There isn't a matching ID")
    }

    @GetMapping("/findAll")
    fun findAll(): List<AdvertBasicDTO> {
        val advertDTO = advertService.findBasicDTO()
        if (advertDTO.isEmpty()) {
            throw NoSuchElementException("There is no players registered")
        }
        return advertDTO
    }
}
