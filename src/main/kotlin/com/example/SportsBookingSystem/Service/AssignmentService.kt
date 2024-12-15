package com.example.SportsBookingSystem.Service
import com.example.SportsBookingSystem.Entity.AssignmentEntity
import com.example.SportsBookingSystem.Repository.AssignmentRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
import kotlin.NoSuchElementException

@Service
class AssignmentService(private val assignmentRepository: AssignmentRepository)
{
    @Transactional
    fun getAssignmentById(id:Long):AssignmentEntity?
    {
        if(assignmentRepository.existsByAssignmentId(id))
        {
            return assignmentRepository.findByAssignmentId(id)
        }
        throw NoSuchElementException("Assignment doesn't exist")
    }

    @Transactional
    fun createAssignment(assignment: AssignmentEntity):AssignmentEntity
    {
       if(assignmentRepository.existsByAssignmentId(assignment.id))
       {
           throw IllegalArgumentException("Assignment already exist")
       }
        return assignmentRepository.save(assignment)
    }

    @Transactional
    fun updateAssignment(id:Long, assignment: AssignmentEntity): AssignmentEntity
    {
        val existsAssignment = assignmentRepository.findByAssignmentId(id)

        if(existsAssignment !=null)
        {
            existsAssignment.name = assignment.name
            existsAssignment.description = assignment.description
            existsAssignment.done = assignment.done
            return assignmentRepository.save(assignment)
        }
        throw NoSuchElementException("Assignment doesn't exist")
    }

    @Transactional
    fun deleteAssignment(id:Long)
    {
        if(assignmentRepository.existsByAssignmentId(id))
        {
            return assignmentRepository.deleteById(id)
        }
        throw NoSuchElementException("Assignment doesn't exist")
    }

    @Transactional
    fun findAssignmentById(id:Long):AssignmentEntity
    {
            return assignmentRepository.findById(id)
                .orElseThrow{NoSuchElementException( "Assignment doesn't exist" ) }
    }

    @Transactional
    fun findAllAssignments():List<AssignmentEntity>
    {
        return assignmentRepository.findAll()
    }

}
