package com.winter.university.controller

import com.winter.university.domain.Lecture
import com.winter.university.service.LectureService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class ProfessorController(
    private val lectureService: LectureService
) {
    @GetMapping("/professor/lectures")
    fun lectures(@RequestParam professorId: Int): List<Lecture> {
        return lectureService.getLectureListForProfessor(professorId)
    }
}