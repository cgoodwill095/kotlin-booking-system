package ServiceUnitTests

import com.example.SportsBookingSystem.Entity.AssignmentEntity
import com.example.SportsBookingSystem.Service.AssignmentService
import io.mockk.*
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class AssignmentServiceUnitTest
{
    val assignmentServices = mockk<AssignmentService>()

    @Test
    fun getAssignmentById_thenReturnAssignmentById()
    {
        val assignment = AssignmentEntity(
            1,
            "this is a test",
            "lol123",
            true)

        every { assignmentServices.getAssignmentById(1) } returns assignment
        val result = assignmentServices.getAssignmentById(1)
        verify{ assignmentServices.getAssignmentById(1) }
        assertEquals(assignment, result)

    }
    @Test
    fun createAssignment_thenReturnAssisgment()
    {
        val assignment = AssignmentEntity(
            1,
            "this is a test",
            "lol123",
            true)

        every {assignmentServices.createAssignment(any())} returns assignment
        val result = assignmentServices.createAssignment(assignment)
        verify {assignmentServices.createAssignment(assignment)}
        assertEquals(assignment, result)
    }

    @Test
    fun updatedAssignment_thenReturnUpdatedAssignment()
    {
        val notUpdated = AssignmentEntity(
            1,
            "this is a test",
            "lol123",
            true)


        val UpdatedAss = AssignmentEntity(
            1,
            "this is not the ",
            "lol123",
            true)

        every { assignmentServices.findAssignmentById(1) } returns notUpdated
        every { assignmentServices.updateAssignment(1, any()) } returns UpdatedAss
        val result = assignmentServices.updateAssignment(1, UpdatedAss)
        println(result)
        assertEquals(UpdatedAss, result)
    }

    @Test
    fun delete_thanDelete()
    {
        val notUpdated = AssignmentEntity(
            1,
            "this is a test",
            "lol123",
            true)

        every { assignmentServices.deleteAssignment(1) } just Runs
        assignmentServices.deleteAssignment(1)
        verify { assignmentServices.deleteAssignment(1) }
    }

    @Test
    fun findByAssignment_thenReturnAssignment()
    {
        val ass = AssignmentEntity(
            1,
            "longName",
            "longdis",
            false)
        every { assignmentServices.findAssignmentById(1) } returns ass
        val result = assignmentServices.findAssignmentById(1)
        assertEquals(ass, result)
        verify { assignmentServices.findAssignmentById(1) }
    }
    @Test
    fun findAll_thenRreturnFindAll()
    {
        val ass = AssignmentEntity(
            1,
            "longName",
            "longdis",
            false)
        val notUpdated = AssignmentEntity(
            1,
            "this is a test",
            "lol123",
            true)
        val list = listOf(ass, notUpdated)
        every{ assignmentServices.findAllAssignments() } returns list
        val result = assignmentServices.findAllAssignments()
        assertEquals(list, result)
        verify { assignmentServices.findAllAssignments() }
    }
}

//@Id
//@GeneratedValue(strategy = GenerationType.IDENTITY)
//var id: Long?,
//var name: String,
//var description: String,
//var done: Boolean) {
//}