package ServiceUnitTests

import com.example.SportsBookingSystem.Entity.AdvertEntity
import com.example.SportsBookingSystem.Repository.AdvertRepository
import com.example.SportsBookingSystem.Service.AdvertService
import io.mockk.*
import kotlin.test.Test
import kotlin.test.assertEquals

class AdvertServiceUnitTest
{
    val advertRepository: AdvertRepository = mockk()
    val avvertService = AdvertService(advertRepository)

    val advert = AdvertEntity(
        "this is a test",
        "hyperlink",
        1,
        1,
        1,
        "staus",
        1)

    val  updatedAdvert = AdvertEntity(
        "updated test",
        "hyperlinkUpdated",
        2,
        2,
        2,
        "staus",
        1)

    @Test
    fun whenGetAdvertById_thanResturnAdvert()
    {
        //given
        every { advertRepository.findAdvertById(1) } returns advert
        //when
        val result = avvertService.getAdvertById(1)
        //then
        verify(exactly = 1) { advertRepository.findAdvertById(1)}
        assertEquals(advert, result)
    }
    @Test
    fun whenCreateAdvery_thenReturnAdvert()
    {
        //given
        every { advertRepository.save(any()) } returns advert
        //when
        val result = avvertService.createAdvert(advert)
        //then
        verify(exactly = 1) { advertRepository.save(advert) }
        assertEquals(advert,result)
    }
    @Test
    fun whenUpdatingAdvert_thenReturnUpdatedAdvert()
    {
        //given
        every { advertRepository.findAdvertById(1) } returns advert
        every { advertRepository.save(any()) } returns updatedAdvert
        //when
        val result = avvertService.updateAdvert(1, updatedAdvert)
        //than
        assertEquals(updatedAdvert,result)
        verify(exactly = 1) { advertRepository.save(updatedAdvert) }
        verify (exactly = 1) { advertRepository.findAdvertById(1) }
    }

    @Test
    fun whenDeleteAdvert_thanReturnNull()
    {
        //given
        every { advertRepository.deleteById(1) } just Runs
        //when
        advertRepository.deleteById(1)
        //then
        verify (exactly = 1) { advertRepository.deleteById(1) }

    }

    @Test
    fun findAdvert_thenReturnAdvert()
    {
        every { advertRepository.findAdvertById(1) } returns advert
        val result = avvertService.findAdvertById(1)
        assertEquals(advert, result)
        verify { advertRepository.findAdvertById(1) }
    }


}