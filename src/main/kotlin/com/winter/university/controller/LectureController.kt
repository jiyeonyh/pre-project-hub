package com.winter.university.controller

import com.winter.university.service.LectureService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class LectureController(
    private val lectureService: LectureService
) {
    @PatchMapping("/lecture/{lectureId}/{professorId}")
    fun update(@PathVariable lectureId: Int, @PathVariable professorId: Int): ResponseEntity<String> {
        lectureService.updateLectureProfessor(lectureId, professorId)
        return ResponseEntity.ok().body("성공")
    }
}