package com.winter.university.controller

import com.winter.university.controller.reponse.BaseResponse
import com.winter.university.domain.Lecture
import com.winter.university.service.LectureService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/professor")
class ProfessorController(
    private val lectureService: LectureService
) {
    @GetMapping("/lectures")
    fun lectures(@RequestParam professorId: Int): BaseResponse<List<Lecture>> {
        val result = lectureService.getLectureListForProfessor(professorId)
        return BaseResponse.success(result)
    }
}