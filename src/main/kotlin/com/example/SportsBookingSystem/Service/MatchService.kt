package com.example.SportsBookingSystem.Service
import com.example.SportsBookingSystem.Entity.MatchEntity
import com.example.SportsBookingSystem.Repository.MatchRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
import kotlin.NoSuchElementException
@Service
class MatchService(private val matchRepository: MatchRepository)
{
    @Transactional
    fun getmatchById(id: Long): MatchEntity?
    {
        if(matchRepository.existsById(id))
        {
            return matchRepository.getReferenceById(id)
        }
        throw NoSuchElementException("This Match doesn't exist")
    }

    @Transactional
    fun createMatch(match: MatchEntity):MatchEntity
    {
        if(matchRepository.existsById(match.id))
        {
            throw IllegalArgumentException("Match already exists")
        }
        return matchRepository.save(match)
    }

    @Transactional
    fun updateMatch(id:Long, match:MatchEntity):MatchEntity
    {
        val existingmatch = matchRepository.getReferenceById(id)
        if(existingmatch != null)
        {
            existingmatch.status = match.status
            existingmatch.description = match.description
            existingmatch.homeScore = match.homeScore
            existingmatch.awayScore = match.awayScore
            return matchRepository.save(existingmatch)
        }
        throw NoSuchElementException("Match does not exist")
    }

    @Transactional
    fun deleteMatch(id:Long)
    {
        if(matchRepository.existsById(id))
        {
            return matchRepository.deleteById(id)
        }
        throw NoSuchElementException("This user does not exist")
    }

    @Transactional
    fun findByMatchId(id:Long): MatchEntity
    {
        return matchRepository.findById(id)
            .orElseThrow(){ NoSuchElementException("No match was found for this ID")}
    }

    @Transactional
    fun findAllMatches(): List<MatchEntity>
    {
        return matchRepository.findAll()
    }
}