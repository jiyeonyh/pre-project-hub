package com.winter.university.controller

import com.winter.university.controller.reponse.BaseResponse
import com.winter.university.controller.request.EnrollmentSaveRequest
import com.winter.university.service.EnrollmentService
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.PathVariable

@RestController
@RequestMapping("/enrollment")
class EnrollmentController(
    private val enrollmentService: EnrollmentService
) {
    @PostMapping("/")
    fun save(@RequestBody request: EnrollmentSaveRequest): BaseResponse<String> {
        enrollmentService.enrollStudentInLecture(request.studentId, request.lectureId)
        return BaseResponse.success(null)
    }

    @DeleteMapping("/{enrollmentId}")
    fun delete(@PathVariable enrollmentId: Int): BaseResponse<String> {
        enrollmentService.deleteEnrollment(enrollmentId)
        return BaseResponse.success(null)
    }
}