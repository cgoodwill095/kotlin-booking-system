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
            return advertRepository.findAdvertById(id)

    }

    @Transactional
    fun createAdvert(advertEntity: AdvertEntity):AdvertEntity
    {
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
            return advertRepository.deleteById(id)
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