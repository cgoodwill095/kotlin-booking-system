package ServiceUnitTests

import com.example.SportsBookingSystem.Entity.MatchEntity
import com.example.SportsBookingSystem.Service.MatchService
import io.mockk.*
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MatchServiceUnitTest
{
    val matchService = mockk<MatchService>()
    @Test
    fun getMatchByID_thanReturnId()
    {
        val match = MatchEntity(
            1,
            1,
            1,
            1,
            1,
            "disLOL",
            "active",
            3,
            2)
        every { matchService.getmatchById(1) } returns match
        val result = matchService.getmatchById(1)
        assertEquals(result,match)
        verify { matchService.getmatchById(1) }
    }

    @Test
    fun createMatch_ThenResturnMatch()
    {
        val match = MatchEntity(
            1,
            1,
            1,
            1,
            1,
            "disLOL",
            "active",
            3,
            2)
        every { matchService.createMatch(any()) } returns match
        val result = matchService.createMatch(match)
        assertEquals(result,match)
        verify { matchService.createMatch(match) }
    }

    @Test
    fun updatematch_thanReturnUpdateMatch()
    {
        val match = MatchEntity(
            1,
            1,
            1,
            1,
            1,
            "disLOL",
            "active",
            3,
            2)

        val updatedMatch = MatchEntity(
            1,
            1,
            1,
            1,
            1,
            "UPDATEDdisLOL",
            "active",
            3,
            2)
        every { matchService.findByMatchId(1) } returns match
        every { matchService.updateMatch(1,any()) } returns updatedMatch
        val result = matchService.updateMatch(1, updatedMatch)
        assertEquals(result, updatedMatch)
        verify { matchService.updateMatch(1, any()) }
    }

   @Test
   fun deleteMatch_thenDelete()
   {
       val match = MatchEntity(
           1,
           1,
           1,
           1,
           1,
           "disLOL",
           "active",
           3,
           2)
       every { matchService.deleteMatch(1) } just Runs
       matchService.deleteMatch(1)
       verify { matchService.deleteMatch(1) }
   }
    @Test
    fun finBYMatchid_thanReturnMatch()
    {
        val match = MatchEntity(
            1,
            1,
            1,
            1,
            1,
            "disLOL",
            "active",
            3,
            2)
        every { matchService.findByMatchId(1) } returns match
        val result = matchService.findByMatchId(1)
        assertEquals(match, result)
        verify { matchService.findByMatchId(1) }
    }

    @Test
    fun findAll_returnAll()
    {
        val match = MatchEntity(
            1,
            1,
            1,
            1,
            1,
            "disLOL",
            "active",
            3,
            2)
        val updatedMatch = MatchEntity(
            1,
            1,
            1,
            1,
            1,
            "UPDATEDdisLOL",
            "active",
            3,
            2)
        val matches = listOf(match,updatedMatch)
        every { matchService.findAllMatches() } returns matches
        val result = matchService.findAllMatches()
        assertEquals(matches,result)
        verify { matchService.findAllMatches() }
    }
}