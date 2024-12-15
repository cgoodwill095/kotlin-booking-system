package com.example.SportsBookingSystem.Service
import com.example.SportsBookingSystem.Entity.AdvertEntity
import com.example.SportsBookingSystem.Repository.AdvertRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
import kotlin.NoSuchElementException

@Service
class AdvertService(private val advertRepository: AdvertRepository)
{
    @Transactional
    fun getAdvertById(id:Long): AdvertEntity?
    {
        if(advertRepository.existsById(id))
        {
            return advertRepository.findAdvertById(id)
        }
        throw NoSuchElementException("This advert doesn't exist")
    }

    @Transactional
    fun createAdvert(advertEntity: AdvertEntity):AdvertEntity
    {
        if(advertRepository.existsById(advertEntity.id))
        {
            throw IllegalArgumentException("This advert already exists")
        }
        return advertRepository.save(advertEntity)
    }

    @Transactional
    fun updateAdvert(id:Long, advert: AdvertEntity):AdvertEntity
    {
        val advertExist = advertRepository.findAdvertById(id)

        if(advertExist!=null)
        {
            advertExist.adtype = advert.adtype
            advertExist.status = advert.status
            advertExist.hyperlink = advert.hyperlink
            return advertRepository.save(advert)
        }
        throw NoSuchElementException("Advert doesn't exist")
    }

    @Transactional
    fun deleteAdvert(id:Long)
    {
        if(advertRepository.existsById(id))
        {
            return advertRepository.deleteById(id)
        }
        throw NoSuchElementException("Advert doesn't exist")
    }

    @Transactional
    fun findAdvertById(id:Long): AdvertEntity
    {
        return advertRepository.findById(id)
            .orElseThrow{NoSuchElementException("Advert doesn't exist")}
    }

    @Transactional
    fun findAllAdverts():List<AdvertEntity>
    {
        return advertRepository.findAll()
    }

}

//var adtype: String,
//var hyperlink: String,
//var matchId: Long?,
//var teamId: Long?,
//var tournamentId: Long?,
//var status: String,