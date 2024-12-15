package com.winter.university.controller

import com.winter.university.controller.request.EnrollmentSaveRequest
import com.winter.university.service.EnrollmentService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class EnrollmentController(
    private val enrollmentService: EnrollmentService
) {
    @PostMapping("/enrollment")
    fun save(@RequestBody request: EnrollmentSaveRequest): ResponseEntity<String> {
        enrollmentService.enrollStudentInLecture(request.studentId, request.lectureId)
        return ResponseEntity.ok().body("성공")
    }

    @DeleteMapping("/enrollment/{studentId}/{lectureId}")
    fun delete(@PathVariable studentId: Int, @PathVariable lectureId: Int): ResponseEntity<String> {
        enrollmentService.deleteEnrollment(studentId, lectureId)
        return ResponseEntity.ok().body("성공")
    }
}