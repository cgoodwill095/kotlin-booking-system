package com.example.SportsBookingSystem.Rest.Controller
import com.example.SportsBookingSystem.DTO.Match.MatchPutDTO
import com.example.SportsBookingSystem.DTO.Match.MatchGetDTO
import com.example.SportsBookingSystem.Entity.MatchEntity
import com.example.SportsBookingSystem.Service.MatchService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException
import java.util.*
import kotlin.NoSuchElementException

@RestController
@RequestMapping("/api/match")

class MatchRestController(private val matchService: MatchService)
{
    @PutMapping("/test")
    fun putMatch(): Boolean
    {
        if(matchService.findAllMatches().isEmpty())
        {
            throw NoSuchElementException("There is no players registered")
        }
        return true
    }
    @PutMapping("/update")
    fun updateMatch(@RequestParam matchId:Long, match:MatchEntity ):MatchPutDTO
    {
        val updatedEntity: MatchEntity = matchService.updateMatch(matchId, match)
        val findID:MatchEntity = matchService.findByMatchId(matchId)
        if(updatedEntity == null)
        {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "Match with id $matchId not found")
        }
        return matchService.mapEnitiyToPutDTO(updatedEntity)
    }



    //http://localhost:8090/api/match/findById?matchId=3
    @GetMapping("/findById")
    fun findById(@RequestParam matchId: Int): MatchGetDTO
    {
        val matchEntity: MatchEntity = matchService.findByMatchId(matchId.toLong())
        if(!matchEntity.equals(null))
        {
            return matchService.mapEnitiyToGetDTO(matchEntity)
        }
        throw NoSuchElementException("there are no matches, matching that id")
    }

    //http://localhost:8090/api/match/findAll
    @GetMapping("/findAll")
    fun findAll(): List<MatchGetDTO>
    {
        val matchDto = matchService.finalAllGetDTO()
        if (!matchDto.isEmpty())
        {
            return matchDto
        }
        throw NoSuchElementException("There are no matches")
    }

    //http://localhost:8090/api/match/findByStatus?status=scheduled
    @GetMapping("/findByStatus")
    fun findAllByStatus(@RequestParam status: String): List<MatchGetDTO>
    {
        if(matchService.findAllByStatus(status).isEmpty())
        {
            throw NoSuchElementException("The Status is not matching any matches")
        }
        return matchService.findAllByStatus(status)
    }

    //http://localhost:8090/api/match/findbyDescription?description=testMatch1
    @GetMapping("/findbyDescription")
    fun findByDescription(@RequestParam description: String):List<MatchGetDTO>
    {
        if(matchService.findAllByDesciption(description).isEmpty())
        {
            throw NoSuchElementException("The description does not match any of the matches")
        }
        return matchService.findAllByDesciption(description)
    }
}

//    @GetMapping("/findByLocationId")
//        fun findByLocation(@RequestParam loationId: Long):MatchGetDTO
//        {
//          val matchEntity: Optional<MatchEntity> = matchService.getMatchByLocationId(loationId)
//            if(matchEntity.isPresent)
//            {
//                return matchService.mapEnitiyToGetDTO(matchEntity.get())
//            }
//            throw NoSuchElementException("The match does not match the location")
//        }

