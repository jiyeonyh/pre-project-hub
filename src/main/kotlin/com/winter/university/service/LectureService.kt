package com.winter.university.service

import com.winter.university.repository.LectureRepository
import com.winter.university.repository.ProfessorRepository

class LectureService(
    private val lectureRepository: LectureRepository,
    private val professorRepository: ProfessorRepository,
) {
    fun updateLectureProfessor(professorId: Int, lectureId: Int){
        val lecture = lectureRepository.findById(lectureId)
            .orElseThrow{ IllegalArgumentException("존재하지 않는 강의 id : $lectureId")}

        val professor = professorRepository.findById(professorId)
            .orElseThrow{ IllegalArgumentException("존재하지 않는 교수 id : $professorId") }

        lecture.professor = professor
        lectureRepository.save(lecture)
    }
}