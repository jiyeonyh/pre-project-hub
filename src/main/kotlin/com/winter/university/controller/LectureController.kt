package com.winter.university.controller

import com.winter.university.controller.reponse.BaseResponse
import com.winter.university.service.LectureService
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/lecture")
class LectureController(
    private val lectureService: LectureService
) {
    @PatchMapping("/{lectureId}/{professorId}")
    fun update(@PathVariable lectureId: Int, @PathVariable professorId: Int): BaseResponse<String> {
        lectureService.updateLectureProfessor(lectureId, professorId)
        return BaseResponse.success(null)
    }
}