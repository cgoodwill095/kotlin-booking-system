package com.example.SportsBookingSystem.Service
import com.example.SportsBookingSystem.Entity.TeamEntity
import com.example.SportsBookingSystem.Repository.TeamRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class TeamService(private val teamRepository: TeamRepository)
{
    @Transactional
    fun getTeamById(id:Long):TeamEntity?
    {
        if(teamRepository.existsByTeamId(id))
        {
            return teamRepository.findTeamById(id)
        }
        throw NoSuchElementException("Team doesn't exist")
    }

    @Transactional
    fun createTeam(team: TeamEntity):TeamEntity
    {
        if(teamRepository.existsByTeamId(team.id))
        {
            throw NoSuchElementException("This Team already exists")
        }
        return teamRepository.save(team)
    }

    @Transactional
    fun updateTeam(id:Long, team: TeamEntity): TeamEntity
    {
        val teamExists = teamRepository.findTeamById(id)
        if(teamExists != null)
        {
            teamExists.name = team.name
            teamExists.homeground = team.homeground
            teamExists.active = team.active
            teamExists.description = team.description
            return teamRepository.save(team)
        }
        throw NoSuchElementException("This team doesn't exists")
    }

    @Transactional
    fun deleteTeam(id:Long)
    {
        if(teamRepository.existsByTeamId(id))
        {
            return teamRepository.deleteById(id)
        }
        throw NoSuchElementException("This Team doesn't exists")
    }

    @Transactional
    fun findTeamById(id:Long):TeamEntity
    {
        return teamRepository.findById(id)
            .orElseThrow{ NoSuchElementException("This Team doesn't exists")}
    }

    @Transactional
    fun findAllTeams():List<TeamEntity>
    {
        return teamRepository.findAll()
    }

}
