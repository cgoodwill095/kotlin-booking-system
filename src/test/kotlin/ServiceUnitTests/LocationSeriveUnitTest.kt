package ServiceUnitTests

import com.example.SportsBookingSystem.Entity.LocationEntity
import com.example.SportsBookingSystem.Service.LocationService
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test
import org.springframework.data.geo.Point
import kotlin.test.assertEquals

class LocationSeriveUnitTest
{
   val locationServices = mockk<LocationService>()
    @Test
    fun getLocationById_thenReturnId()
    {
        val geolocation = Point(10.2,11.2)
        val location = LocationEntity(
            1,
            "name",
            "dis",
            true,
            geolocation)

        every { locationServices.getLocationById(1) } returns location
        val result = locationServices.getLocationById(1)
        assertEquals(location, result)
        verify { locationServices.getLocationById(1) }
    }
    @Test
    fun createLocation_theReturnLocation()
    {
        val geolocation = Point(10.2,11.2)
        val location = LocationEntity(
            1,
            "name",
            "dis",
            true,
            geolocation)

        every { locationServices.createLocation(any()) } returns location
        val result = locationServices.createLocation(location)
        assertEquals(location, result)
        verify { locationServices.createLocation(location) }
    }

    @Test
    fun updateLocation_thenReturnUpdatedLocation()
    {
        val geolocation = Point(10.2,11.2)
        val location = LocationEntity(
            1,
            "name",
            "dis",
            true,
            geolocation)

        val updatedLocation = LocationEntity(
            1,
            "nameUpdated",
            "disUpdayed",
            true,
            geolocation)
        every { locationServices.findLocationById(1) } returns location
        every { locationServices.updateLocation(1, updatedLocation) } returns updatedLocation
        val result = locationServices.updateLocation(1, updatedLocation)
        assertEquals(result, updatedLocation)
        verify { locationServices.updateLocation(1, updatedLocation) }
    }
}