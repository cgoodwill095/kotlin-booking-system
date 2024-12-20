package com.example.SportsBookingSystem.Controller
import com.example.SportsBookingSystem.Entity.TeamEntity
import com.example.SportsBookingSystem.Service.TeamService
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/team")
class TeamController(private val teamService: TeamService)
{
    @GetMapping("/findAll")
    fun findAllTeams():List<TeamEntity>
    {
        if(teamService.findAllTeams().isEmpty())
        {
            throw NoSuchElementException("There is no teams registered")
        }
        return teamService.findAllTeams()
    }

    @GetMapping( "/get{id}")
    fun getTeamById(@PathVariable id:Long):ResponseEntity <TeamEntity>
    {
        val foundTeam = teamService.getTeamById(id)
        if (foundTeam != null)
        {
            throw NoSuchElementException ("This Team doesn't exist")
        }
        return ResponseEntity.ok(foundTeam);
    }

    @GetMapping("/find{id}")
    fun findTeamById(@PathVariable id:Long): ResponseEntity<TeamEntity>
    {
        val foundTeam = teamService.findTeamById(id)
        return ResponseEntity.ok(foundTeam)
    }

    @PostMapping("/createTeam")
    fun createTeam (team:TeamEntity):ResponseEntity<TeamEntity>
    {
        val teamCration = teamService.createTeam(team)
        return ResponseEntity.ok(teamCration)
    }

    @PutMapping("updateTeam{id}")
    fun updateTeam(@PathVariable id:Long, @RequestBody team:TeamEntity): ResponseEntity<TeamEntity>
    {
        val updatedPlayer = teamService.updateTeam(id,team)
        return ResponseEntity.ok(updatedPlayer)
    }

    @DeleteMapping("/delete{id}")
    fun deleteTeam(@PathVariable id:Long):ResponseEntity<Void>
    {
        teamService.deleteTeam(id)
        return ResponseEntity.noContent().build()
    }
}