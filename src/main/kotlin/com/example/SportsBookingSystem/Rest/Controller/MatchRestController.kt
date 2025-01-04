package com.example.SportsBookingSystem.Rest.Controller

import com.example.SportsBookingSystem.DTO.Match.MatchGetDTO
import com.example.SportsBookingSystem.Entity.MatchEntity
import com.example.SportsBookingSystem.Service.MatchService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.*
import kotlin.NoSuchElementException

@RestController
@RequestMapping("/api/match")

class MatchRestController(private val matchService: MatchService)
{
    @GetMapping("/findById")
    fun findById(@RequestParam matchId: Int): MatchGetDTO
    {
        val matchEntity: Optional<MatchEntity> = matchService.getmatchById(matchId.toLong())
        if(matchEntity.isPresent)
        {
            return matchService.mapEnitiyToGetDTO(matchEntity.get())
        }
        throw NoSuchElementException("there are no matches, matching that id")
    }

    @GetMapping("/findByLocationId")
        fun findByLocation(@RequestParam loationId: Long):MatchGetDTO
        {
          val matchEntity: Optional<MatchEntity> = matchService.getMatchByLocationId(loationId)
            if(matchEntity.isPresent)
            {
                return matchService.mapEnitiyToGetDTO(matchEntity.get())
            }
            throw NoSuchElementException("The match does not match the location")
        }

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

    @GetMapping("/findByStatus")
    fun findAllByStatus(@RequestParam status: String): List<MatchGetDTO>
    {
        if(matchService.findAllByStatus(status).isEmpty())
        {
            throw NoSuchElementException("The Status is not matching any matches")
        }
        return matchService.findAllByStatus(status)
    }

    @GetMapping("/findbyDescription")
    fun findByDescription(@RequestParam description: String):List<MatchGetDTO>
    {
        if(matchService.findAllByDesciption(description).isEmpty())
        {
            throw NoSuchElementException("The description does not match any of the matches")
        }
        return matchService.findAllByDesciption(description)
    }

    @PutMapping("/")
    fun putMatch():Boolean
    {
        if(matchService.findAllMatches().isEmpty())
        {
            throw NoSuchElementException("There are not matches registered")
        }
        return true
    }
}

