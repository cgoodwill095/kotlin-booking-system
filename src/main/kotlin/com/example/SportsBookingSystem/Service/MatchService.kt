package com.example.SportsBookingSystem.Service
import com.example.SportsBookingSystem.DTO.Match.MatchGetDTO
import com.example.SportsBookingSystem.Entity.MatchEntity
import com.example.SportsBookingSystem.Mapper.MatchMapper
import com.example.SportsBookingSystem.Repository.MatchRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
import java.util.Optional
import kotlin.NoSuchElementException
@Service
class MatchService(private val matchRepository: MatchRepository,
    private val matchMapper: MatchMapper)
{
    @Transactional
    fun getmatchById(id: Long): Optional<MatchEntity>
    {
        if(matchRepository.existsById(id))
        {
            return matchRepository.findById(id)
        }
        throw NoSuchElementException("This Match doesn't exist")
    }

//    @Transactional
//    fun getMatchByLocationId(id:Long): Optional<MatchEntity>
//    {
//        return matchRepository.findByLocation_id(id)
//    }

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
        val matchEntity: Optional<MatchEntity> = matchRepository.findById(id)

        if(matchEntity.isPresent)
        {
            matchEntity.get().status = match.status
            matchEntity.get().description = match.description
            return matchRepository.save(matchEntity.get())
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

    @Transactional
    fun finalAllGetDTO():List<MatchGetDTO>
    {
        val matches:List<MatchEntity> = matchRepository.findAll()
        if (!matches.isEmpty())
        {
            val matchDTO = mutableListOf<MatchGetDTO>()
            for(match in matches)
            {
                matchDTO.add(matchMapper.mapEntityToBasicGetDTO(match))
            }
            return matchDTO
        }
        throw NoSuchElementException("There are currently no matches")
    }

    @Transactional
    fun findAllByStatus(status: String):List<MatchGetDTO>
    {
        val matchDTO = mutableListOf<MatchGetDTO>()
        for (match in matchRepository.findAllByStatus(status))
        {
           matchDTO.add(matchMapper.mapEntityToBasicGetDTO(match))
        }
        return matchDTO
    }

    @Transactional
    fun findAllByDesciption(description: String):List<MatchGetDTO>
    {
        val matchDTO = mutableListOf<MatchGetDTO>()
        for (match in matchRepository.findAllByDescription(description))
        {
            matchDTO.add(matchMapper.mapEntityToBasicGetDTO(match))
        }
        return matchDTO
    }

    @Transactional
    fun mapEnitiyToGetDTO(match: MatchEntity): MatchGetDTO
    {
        return matchMapper.mapEntityToBasicGetDTO(match)
    }
}