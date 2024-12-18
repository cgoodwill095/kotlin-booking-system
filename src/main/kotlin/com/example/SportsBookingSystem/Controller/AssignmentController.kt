package com.example.SportsBookingSystem.Controller
import com.example.SportsBookingSystem.Entity.AssignmentEntity
import com.example.SportsBookingSystem.Service.AssignmentService
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping
class AssignmentController(private val assignmentService: AssignmentService)
{
    @GetMapping("/findAll")
    fun findAllAssignments():List<AssignmentEntity>
    {
        return assignmentService.findAllAssignments()
    }

    @GetMapping("/get{id}")
    fun getAssignmentById(@PathVariable id:Long):ResponseEntity<AssignmentEntity>
    {
        val getAssignment = assignmentService.getAssignmentById(id)
        return ResponseEntity.ok(getAssignment)
    }
    @GetMapping("/find{id}")
    fun findAssignmentById(@PathVariable id:Long):ResponseEntity<AssignmentEntity>
    {
        val found = assignmentService.findAssignmentById(id)
        return ResponseEntity.ok(found)
    }
    @PostMapping("/createAssignment")
    fun createAssignment(@RequestBody assignment: AssignmentEntity):ResponseEntity<AssignmentEntity>
    {
        val createAssignment = assignmentService.createAssignment(assignment)
        return ResponseEntity.ok(createAssignment)
    }

    @PutMapping("/updateAssignment{id}")
    fun updateAssignment(@PathVariable id:Long, @RequestBody assignment:AssignmentEntity):ResponseEntity<AssignmentEntity>
    {
        val updatedAssignment = assignmentService.updateAssignment(id, assignment)
        return ResponseEntity.ok(updatedAssignment)
    }

    @DeleteMapping("/delete{id}")
    fun deleteAssignment(@PathVariable id:Long):ResponseEntity<AssignmentEntity>
    {
        assignmentService.deleteAssignment(id)
        return ResponseEntity.noContent().build()
    }
}
