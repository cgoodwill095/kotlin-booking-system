package com.example.SportsBookingSystem.Controller
import com.example.SportsBookingSystem.Entity.MatchEntity
import com.example.SportsBookingSystem.Service.MatchService
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/match")
class MatchController(private val matchService: MatchService)
{
    @GetMapping("/findAll")
    fun findAll(): List<MatchEntity>
    {
        if(matchService.findAllMatches().isEmpty())
        {
           throw NoSuchElementException("There is no matches registered")
        }
        return matchService.findAllMatches()
    }

    @GetMapping("/getMatch{id}")
    fun getmatchById(@PathVariable id:Long): ResponseEntity<MatchEntity>
    {
        val match = matchService.getmatchById(id)
        if(match != null)
        {
            return ResponseEntity.notFound().build()
        }
        return ResponseEntity.ok(match)
    }

    @GetMapping("/findMatch{id}")
    fun findByMatchId(@PathVariable id:Long): ResponseEntity<MatchEntity>
    {
        val foundMatch = matchService.findByMatchId(id)
        if(foundMatch.equals(null))
        {
            throw NoSuchElementException("that match doesn't exist")
        }
        return ResponseEntity.ok(foundMatch)
    }

    @PostMapping("/createMatch")
    fun createMatch(@RequestBody match: MatchEntity):ResponseEntity<MatchEntity>
    {
        val createMatch = matchService.createMatch(match)
        return ResponseEntity.ok(createMatch)
    }

    @PutMapping("/updateMatch{id}")
    fun updateMatch(@RequestBody match: MatchEntity, @PathVariable id:Long):ResponseEntity<MatchEntity>
    {
        val updateMatch = matchService.updateMatch(id, match)
        return ResponseEntity.ok(updateMatch)
    }

    @DeleteMapping("/delete{id}")
    fun deleteMatch(@PathVariable id:Long): ResponseEntity<Void>
    {
        matchService.deleteMatch(id)
        return ResponseEntity.noContent().build()
    }
}